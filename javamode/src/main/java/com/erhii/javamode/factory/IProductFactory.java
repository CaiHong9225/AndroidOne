package com.erhii.javamode.factory;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.javamode.factory
 * @ClassName: IProductFactory
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/8/26 17:01
 * @UpdateUser: admin
 * @UpdateDate: 2019/8/26 17:01
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IProductFactory {
    /**
     * 生产手机
     * @return
     */
    IPhoneProduct produceTelPhone();

    /**
     * 生产路由器
     * @return
     */
    IRouterProduct produceRouter();
}
