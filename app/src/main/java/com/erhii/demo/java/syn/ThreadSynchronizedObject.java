package com.erhii.demo.java.syn;

class ThreadSynchronizedObject {

    private Object object = new Object();
    //对静态方法加同步锁，会让类处于同步状态，不管生成几个对象

    public   synchronized void threadMethodA() throws InterruptedException {
        ThreadSynchronizedTimeUtils.setMethodAIntoTime();
        System.out.println(Thread.currentThread().getName() + ",进入threadMethodA");
        Thread.sleep(1000); ///<模拟方法请求耗时
        System.out.println(Thread.currentThread().getName() + ",退出threadMethodA");
        ThreadSynchronizedTimeUtils.setMethodAOutTime();
    }
    //synchronized(this) 会让类中各个同步方法依次执行
    //而 synchronized(object) 或者synchronized(.class) 则只会同步当前方法
    public   void threadMethodB() throws InterruptedException {
        synchronized (ThreadSynchronizedObject.class) {
            ThreadSynchronizedTimeUtils.setMethodBIntoTime();
            System.out.println(Thread.currentThread().getName() + ",进入threadMethodB");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ",退出threadMethodB");
            ThreadSynchronizedTimeUtils.setMethodBOutTime();
        }
    }
}