package com.erhii.demo.java.syn;

class ThreadSynchronizedTimeUtils {

    public static long mMethodAIntoTime;
    public static long mMethodAOutTime;
    public static long mMethodBIntoTime;
    public static long mMethodBOutTime;

    public static void setMethodAIntoTime() {
        mMethodAIntoTime = System.currentTimeMillis();
    }

    public static void setMethodAOutTime() {
        mMethodAOutTime = System.currentTimeMillis();
    }

    public static void setMethodBIntoTime() {
        mMethodBIntoTime = System.currentTimeMillis();
    }

    public static void setMethodBOutTime() {
        mMethodBOutTime = System.currentTimeMillis();
    }
}