package com.erhii.cevent.listener;

import android.text.TextUtils;
import android.util.Log;

import com.erhii.cevent.event.CEvent;
import com.erhii.cevent.event.CEventObjPool;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.cevent.listener
 * @ClassName: CEventCenter
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/6/14 18:00
 * @UpdateUser: admin
 * @UpdateDate: 2019/6/14 18:00
 * @UpdateRemark:
 * @Version: 1.0
 *
 *
 *
 *在A Activity的onCreate()方法中，调用CEventCenter.registerEventListener(I_CEventListener listener, String topic/String[] topics) 方法注册监听器
 *
 * A Activity需要实现I_CEventListener接口，重写onCEvent(String topic, int msgCode, int resultCode, Object obj)方法
 *
 * 同时不要忘记在onDestroy()方法中调用CEventCenter.unregisterEventListener(I_CEventListener listener, String topic/String[] topics) 方法注销监听器
 *
 *
 *B Activity中，调用CEventCenter.dispatchEvent(CEvent event/ String topic, int msgCode, int resultCode, Object obj) 方法发布事件
 *
 *
 *
 *
 *
 * 功能缺陷点 ：无法实现粘性广播
 *
 *
 */
public class CEventCenter {
    private static final String TAG = CEventCenter.class.getSimpleName();

    /**
     * 监听器列表，支持一对多存储 全局中都能使用长生命周期
     *
     * 只要静态变量没有被销毁也没有置null，其对象一直被保持引用，也即引用计数不可能是0，因此不会被垃圾回收。因此，单例对象在运行时不会被回收。
     */
    private static final HashMap<String, Object> LISTENER_MAP = new HashMap<>();

    /**
     * 监听器列表锁
     */
    private static final Object LISTENER_LOCK = new Object();

    /**
     * 事件对象池
     */
    private static final CEventObjPool POOL = new CEventObjPool(5);

    /**
     * 注册/注销监听器
     *
     * @param toBind   true注册  false注销
     * @param listener 监听器
     * @param topic    单个主题
     */
    public static void onBindEvent(boolean toBind, I_CEventListener listener, String topic) {
        onBindEvent(toBind, listener, new String[]{topic});
    }

    /**
     * 注册/注销监听器
     *
     * @param toBind   true注册  false注销
     * @param listener 监听器
     * @param topics   多个主题
     */
    public static void onBindEvent(boolean toBind, I_CEventListener listener, String[] topics) {
        if (toBind) {
            registerEventListener(listener, topics);
        } else {
            unregisterEventListener(listener, topics);
        }
    }

    /**
     * 注册监听器
     *
     * @param listener 监听器
     * @param topic    单个主题
     */
    public static void registerEventListener(I_CEventListener listener, String topic) {
        registerEventListener(listener, new String[]{topic});
    }

    /**
     * 注册监听器
     *
     * @param listener 监听器
     * @param topics   多个主题
     */
    public static void registerEventListener(I_CEventListener listener, String[] topics) {
        if (null == listener || null == topics) {
            return;
        }

        synchronized (LISTENER_LOCK) {
            for (String topic : topics) {
                if (TextUtils.isEmpty(topic)) {
                    continue;
                }

                Object obj = LISTENER_MAP.get(topic);
                if (null == obj) {
                    // 还没有监听器，直接放到Map集合
                    LISTENER_MAP.put(topic, listener);
                } else if (obj instanceof I_CEventListener) {
                    // 有一个监听器
                    I_CEventListener oldListener = (I_CEventListener) obj;
                    if (listener == oldListener) {
                        // 去重
                        continue;
                    }
                    LinkedList<I_CEventListener> list = new LinkedList<>();
                    list.add(oldListener);
                    list.add(listener);
                    LISTENER_MAP.put(topic, list);
                } else if (obj instanceof List) {
                    // 有多个监听器
                    LinkedList<I_CEventListener> listeners = (LinkedList<I_CEventListener>) obj;
                    if (listeners.indexOf(listener) >= 0) {
                        // 去重
                        continue;
                    }
                    listeners.add(listener);
                }
            }
        }
    }

    /**
     * 注销监听器
     *
     * @param listener 监听器
     * @param topic    单个主题
     */
    public static void unregisterEventListener(I_CEventListener listener, String topic) {
        unregisterEventListener(listener, new String[]{topic});
    }

    /**
     * 注销监听器
     *
     * @param listener 监听器
     * @param topics   多个主题
     */
    public static void unregisterEventListener(I_CEventListener listener, String[] topics) {
        if (null == listener || null == topics) {
            return;
        }
        synchronized (LISTENER_LOCK) {
            for (String topic : topics) {
                if (TextUtils.isEmpty(topic)) {
                    continue;
                }
                Object obj = LISTENER_MAP.get(topic);
                if (null == obj) {
                    continue;
                } else if (obj instanceof I_CEventListener) {
                    // 有一个监听器
                    if (obj == listener) {
                        LISTENER_MAP.remove(topic);
                    }
                } else if (obj instanceof List) {
                    // 有多个监听器
                    LinkedList<I_CEventListener> listeners = (LinkedList<I_CEventListener>) obj;
                    listeners.remove(listener);
                }
            }
        }
    }

    /**
     * 同步分发事件
     *
     * @param topic      主题
     * @param msgCode    消息类型
     * @param resultCode 预留参数
     * @param obj        回调返回数据
     */
    public static void dispatchEvent(String topic, int msgCode, int resultCode, Object obj) {
        if (!TextUtils.isEmpty(topic)) {
            CEvent event = POOL.get();
            event.setTopic(topic);
            event.setMsgCode(msgCode);
            event.setResultCode(resultCode);
            event.setObj(obj);
            dispatchEvent(event);
        }
    }

    /**
     * 同步分发事件
     *
     * @param event
     */
    private static void dispatchEvent(CEvent event) {
        // 没有监听器，直接跳出代码，无需执行以下代码
        if (LISTENER_MAP.size() == 0) {
            return;
        }

        if (null != event && !TextUtils.isEmpty(event.getTopic())) {
            String topic = event.getTopic();
            // 通知事件监听器处理事件
            I_CEventListener listener = null;
            LinkedList<I_CEventListener> listeners = null;

            synchronized (LISTENER_LOCK) {
                Log.d(TAG, "dispatchEvent | topic = " + topic + "\tmsgCode = " + event.getMsgCode()
                        + "\tresultCode = " + event.getResultCode() + "\tobj = " + event.getObj());
                Object obj = LISTENER_MAP.get(topic);
                if (obj == null) {
                    return;
                }
                if (obj instanceof I_CEventListener) {
                    listener = (I_CEventListener) obj;
                } else if (obj instanceof LinkedList) {
                    listeners = (LinkedList<I_CEventListener>) ((LinkedList) obj).clone();
                }
            }

            // 分发事件
            if (null != listener) {
                listener.onCEvent(topic, event.getMsgCode(), event.getResultCode(), event.getObj());
            } else if (null != listeners && listeners.size() > 0) {
                for (I_CEventListener l : listeners) {
                    l.onCEvent(topic, event.getMsgCode(), event.getResultCode(), event.getObj());
                }
            }

            // 把对象放回池里面
            POOL.returnObj(event);
        }
    }


}
