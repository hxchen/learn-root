package com.a3fun.learn.concurrency.threads.conditionWait;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {
    //定义锁
    static Lock lock = new ReentrantLock();
    //获得Condition对象
    static Condition condition = lock.newCondition();

    //定义线程子类
    static class SubThread extends Thread{
        @Override
        public void run() {
            try {
                lock.lock();    //在调用await()前必须先获得锁
                System.out.println(Thread.currentThread().getName() + "method lock");
                System.out.println(Thread.currentThread().getName() + "开始等待");
                condition.await();      //等待
                System.out.println(Thread.currentThread().getName() + "等待结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();      //释放锁
                System.out.println(Thread.currentThread().getName() + "method unlock");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SubThread t = new SubThread();
        t.start();
        //子线程启动后,会转入等待状态

        Thread.sleep(3000);
        //主线程在睡眠3秒后,唤醒子线程的等待
        try {
            lock.lock();
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
