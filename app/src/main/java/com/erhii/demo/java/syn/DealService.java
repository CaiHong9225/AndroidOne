package com.erhii.demo.java.syn;

/**
 * 死锁实例
 */
class DealService {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void methodA() {
        System.out.println("" + Thread.currentThread().getName() + ",等待获取lock1");
        synchronized (lock1) {
            try {
                System.out.println("" + Thread.currentThread().getName() + ",持有lock1");
                Thread.sleep(2000);
                System.out.println("" + Thread.currentThread().getName() + ",等待获取lock2");
                synchronized (lock2) {
                    System.out.println("" + Thread.currentThread().getName() + ",持有lock2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodB() {
        System.out.println("" + Thread.currentThread().getName() + ",等待获取lock2");
        synchronized (lock2) {
            try {
                System.out.println("" + Thread.currentThread().getName() + ",持有lock2");
                Thread.sleep(2000);
                System.out.println("" + Thread.currentThread().getName() + ",等待获取lock1");
                synchronized (lock1) {
                    System.out.println("" + Thread.currentThread().getName() + ",持有lock1");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}