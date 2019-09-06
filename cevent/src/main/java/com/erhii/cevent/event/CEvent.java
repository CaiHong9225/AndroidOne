package com.erhii.cevent.event;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.cevent.event
 * @ClassName: CEvent
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/6/14 17:53
 * @UpdateUser: admin
 * @UpdateDate: 2019/6/14 17:53
 * @UpdateRemark:
 * @Version: 1.0
 */
public class CEvent implements PooledObject {
    private String topic;   // 主题
    private int msgCode;    // 消息类型
    private int resultCode; // 预留参数
    private Object obj;     // 回调返回数据

    public CEvent() {
    }

    public CEvent(String topic, int msgCode, int resultCode, Object obj) {
        this.topic = topic;
        this.msgCode = msgCode;
        this.resultCode = resultCode;
        this.obj = obj;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(int msgCode) {
        this.msgCode = msgCode;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public void reset() {
        this.topic = null;
        this.msgCode = 0;
        this.resultCode = 0;
        this.obj = null;
    }
}
