package com.erhii.nanotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法注解
 * @ProjectName: Demo
 * @Package: com.erhii.nanotation
 * @ClassName: UserCases
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/8/19 15:42
 * @UpdateUser: admin
 * @UpdateDate: 2019/8/19 15:42
 * @UpdateRemark:
 * @Version: 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserCases {
    public String id();

    public String description() default "no description";
}
