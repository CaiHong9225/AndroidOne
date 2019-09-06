package com.erhii.javamode.builder.android;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.javamode.builder.android
 * @ClassName: Animal
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/8/26 16:54
 * @UpdateUser: admin
 * @UpdateDate: 2019/8/26 16:54
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Animal {
    private final String name;
    private final String color;
    private final int count;

    private Animal(Builder builder) {
        name = builder.name;
        color = builder.color;
        count = builder.count;
    }

    public static final class Builder {
        private final String name;
        private final String color;
        private final int count;

        public Builder(String name, String color, int count) {
            this.name = name;
            this.color = color;
            this.count = count;
        }

        public Animal build() {
            return new Animal(this);
        }
    }
}
