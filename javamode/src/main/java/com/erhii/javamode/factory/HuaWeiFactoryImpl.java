package com.erhii.javamode.factory;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.javamode.factory
 * @ClassName: HuaWeiFactoryImpl
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/8/26 17:02
 * @UpdateUser: admin
 * @UpdateDate: 2019/8/26 17:02
 * @UpdateRemark:
 * @Version: 1.0
 */
public class HuaWeiFactoryImpl implements IProductFactory {
    @Override
    public IPhoneProduct produceTelPhone() {
        return new HuaWeiPhoneImpl();
    }

    @Override
    public IRouterProduct produceRouter() {
        return new HuaWeiRouterImpl();
    }
}
