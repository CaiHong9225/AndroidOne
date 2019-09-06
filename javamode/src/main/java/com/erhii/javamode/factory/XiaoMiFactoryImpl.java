package com.erhii.javamode.factory;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.javamode.factory
 * @ClassName: XiaoMiFactoryImpl
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/8/26 17:02
 * @UpdateUser: admin
 * @UpdateDate: 2019/8/26 17:02
 * @UpdateRemark:
 * @Version: 1.0
 */
public class XiaoMiFactoryImpl implements IProductFactory {

    @Override
    public IPhoneProduct produceTelPhone() {
        return new XiaoMiPhoneImpl();
    }

    @Override
    public IRouterProduct produceRouter() {
        return new XiaoMiRouterImpl();
    }
}
