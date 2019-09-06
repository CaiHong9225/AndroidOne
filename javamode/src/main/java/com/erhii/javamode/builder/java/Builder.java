package com.erhii.javamode.builder.java;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.javamode.builder.java
 * @ClassName: Builder
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/8/26 16:37
 * @UpdateUser: admin
 * @UpdateDate: 2019/8/26 16:37
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface Builder {
    void init();
    void buildName();
    void buildAge();
    Product getProduct();
}
