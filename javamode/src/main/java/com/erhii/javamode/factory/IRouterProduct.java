package com.erhii.javamode.factory;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.javamode.factory
 * @ClassName: IRouterProduct
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/8/26 16:58
 * @UpdateUser: admin
 * @UpdateDate: 2019/8/26 16:58
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IRouterProduct {
    /**
     * 开机
     */
    void start();

    /**
     * 关机
     */
    void shutdown();

    /**
     * 开启wifi
     */
    void openWifi();

    /**
     * 设置参数
     */
    void setting();

}
