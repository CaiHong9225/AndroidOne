package com.erhii.demo.java.syn;

class ThreadVolatileRunnable implements Runnable {
    /**
     * 外部設置 变量 能在进程中获取到
     */
    private  volatile boolean isPrint = true;

    public void setPrint(boolean flag) {
        this.isPrint = flag;
        if(!flag)
            System.out.println("" + Thread.currentThread().getName() + ",尝试让线程退出!");
    }

    public void run() {
        int num =0;
        while (isPrint) {
            num++;
        }
        System.out.println("" + Thread.currentThread().getName() + ",停止运行!num:" + num);
    }
}