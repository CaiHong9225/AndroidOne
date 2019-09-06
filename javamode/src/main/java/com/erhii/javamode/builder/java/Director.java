package com.erhii.javamode.builder.java;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.javamode.builder.java
 * @ClassName: Director
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/8/26 16:45
 * @UpdateUser: admin
 * @UpdateDate: 2019/8/26 16:45
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void buildProduct() {
        builder.buildName();
        builder.buildAge();
    }

    public Product getProduct() {
        return builder.getProduct();
    }
}
