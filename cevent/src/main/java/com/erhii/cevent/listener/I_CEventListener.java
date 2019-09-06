package com.erhii.cevent.listener;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.cevent.listener
 * @ClassName: I_CEventListener
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/6/14 17:59
 * @UpdateUser: admin
 * @UpdateDate: 2019/6/14 17:59
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface I_CEventListener {
    /**
     * 事件回调函数
     * <b>注意：</b><br />
     * 如果 obj 使用了对象池，<br />
     * 那么事件完成后，obj即自动回收到对象池，请不要再其它线程继续使用，否则可能会导致数据不正常
     *
     * @param topic
     * @param msgCode
     * @param resultCode
     * @param obj
     */
    void onCEvent(String topic, int msgCode, int resultCode, Object obj);
}
