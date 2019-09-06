package com.erhii.demo.java.syn;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.demo.java.syn
 * @ClassName: ThreadSynchronizedDemo
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/4/3 11:14
 * @UpdateUser: admin
 * @UpdateDate: 2019/4/3 11:14
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ThreadSynchronizedDemo {

    public static void main(String[] args) throws InterruptedException {
        final ThreadSynchronizedObject object = new ThreadSynchronizedObject();
        final ThreadSynchronizedObject object1 = new ThreadSynchronizedObject();
        Thread thread_1 = new Thread("thread_1") {
            public void run() {
                try {
                    object.threadMethodA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ;
        };
        Thread thread_2 = new Thread("thread_2") {
            public void run() {
                try {
                    object1.threadMethodB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ;
        };
        thread_1.start();
        thread_2.start();
        Thread.sleep(3000);
        long start_time = (ThreadSynchronizedTimeUtils.mMethodAIntoTime - ThreadSynchronizedTimeUtils.mMethodBIntoTime) > 0 ? ThreadSynchronizedTimeUtils.mMethodAIntoTime
                : ThreadSynchronizedTimeUtils.mMethodBIntoTime;
        long end_time = (ThreadSynchronizedTimeUtils.mMethodAOutTime - ThreadSynchronizedTimeUtils.mMethodBOutTime) > 0 ? ThreadSynchronizedTimeUtils.mMethodAOutTime
                : ThreadSynchronizedTimeUtils.mMethodBOutTime;
        System.out.println("总耗时:" + (end_time - start_time));
    }

    /**
     * 死鎖實例
     */
    private void lockDemo() {
        final DealService dealService = new DealService();
        Thread thread_1 = new Thread("thread_1") {
            public void run() {
                dealService.methodA();
            }

            ;
        };
        Thread thread_2 = new Thread("thread_2") {
            public void run() {
                dealService.methodB();

            }

            ;
        };
        thread_1.start();
        thread_2.start();
    }
}
