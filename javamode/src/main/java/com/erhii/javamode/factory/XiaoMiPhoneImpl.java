package com.erhii.javamode.factory;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.javamode.factory
 * @ClassName: XiaoMiPhoneImpl
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/8/26 16:58
 * @UpdateUser: admin
 * @UpdateDate: 2019/8/26 16:58
 * @UpdateRemark:
 * @Version: 1.0
 */
public class XiaoMiPhoneImpl implements IPhoneProduct {
    @Override
    public void start() {
        System.out.println("开启小米手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米手机");
    }

    @Override
    public void callUp() {
        System.out.println("用小米手机打电话");
    }

    @Override
    public void sendSMS() {
        System.out.println("用小米手机发短信");
    }
}
