package com.erhii.demo.java.syn;

/**
 * volatile 實例
 */
public class ThreadVolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadVolatileRunnable runnable = new ThreadVolatileRunnable();
        Thread thread = new Thread(runnable, "thread_1");
        thread.start();
        Thread.sleep(1000);
        runnable.setPrint(false);
    }
}