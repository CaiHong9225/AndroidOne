package com.erhii.cevent.event;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.cevent.event
 * @ClassName: CEventObjPool
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/6/14 17:57
 * @UpdateUser: admin
 * @UpdateDate: 2019/6/14 17:57
 * @UpdateRemark:
 * @Version: 1.0
 */
public class CEventObjPool extends ObjectPool<CEvent> {


    public CEventObjPool(int capacity) {
        super(capacity);
    }

    @Override
    protected CEvent[] createObjPool(int capacity) {
        return new CEvent[capacity];
    }

    @Override
    protected CEvent createNewObj() {
        return new CEvent();
    }
}
