package com.a3fun.learn.concurrency.lock;

public class SynLockDemo2 {
    int count = 0;
    public void addOne() throws InterruptedException {
        synchronized (this){
            while (true){
                count += 1;
                System.out.println(Thread.currentThread().getName() + " 执行 + 1");
                Thread.sleep(1000);
            }
        }
    }

    public void addTwo() throws InterruptedException {
        synchronized (SynLockDemo2.class){
            while (true){
                count += 1;
                System.out.println(Thread.currentThread().getName() + " 执行 + 1");
                Thread.sleep(1000);
            }
        }
    }
}
