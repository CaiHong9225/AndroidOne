package com.erhii.javamode.builder.java;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.javamode.builder.java
 * @ClassName: CarBuilder
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/8/26 16:41
 * @UpdateUser: admin
 * @UpdateDate: 2019/8/26 16:41
 * @UpdateRemark:
 * @Version: 1.0
 */
public class CarBuilder implements Builder {
    Product mProduct;

    @Override
    public void init() {
        mProduct = new Product();
    }

    @Override
    public void buildName() {
        mProduct.setmName("汽车");
    }

    @Override
    public void buildAge() {
        mProduct.setmAge(15);
    }


    @Override
    public Product getProduct() {
        return mProduct;
    }
}
