package com.erhii.javamode.builder.android;

import android.os.Build;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.javamode.builder.android
 * @ClassName: Person
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/8/26 16:49
 * @UpdateUser: admin
 * @UpdateDate: 2019/8/26 16:49
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Person {
    private final String mName;
    private final int mAge;
    private final int mGender;
    private final String mAddre;

    public Person(Builder builder) {
        this.mName = builder.mName;
        this.mAge = builder.mAge;
        this.mGender = builder.mGender;
        this.mAddre = builder.mAddre;
    }

    public String getmName() {
        return mName;
    }

    public int getmAge() {
        return mAge;
    }

    public int getmGender() {
        return mGender;
    }

    public String getmAddre() {
        return mAddre;
    }

    public static final class Builder {

        private String mName;
        private int mAge;
        private int mGender;
        private String mAddre;

        public Builder(String mName, int mAge, int mGender) {
            this.mName = mName;
            this.mAge = mAge;
            this.mGender = mGender;
        }

        public Builder setAddress(String val) {
            mAddre = val;
            return this;
        }

        public Person create() {
            return new Person(this);
        }
    }
}
