package com.a3fun.learn.concurrency.threads.printNum;

public class WaitAndNotify {
    public static void main(String[] args) {
        // 同一个任务放到2个线程
        PrintRunnable runnable = new PrintRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
    }
    static class PrintRunnable implements Runnable{
        volatile int i = 1;
        @Override
        public void run() {
            while (true){
                synchronized (this){    // 加锁
                    notify();   // 调用notify()不会直接唤醒下一个线程，需要等synchronized代码块执行完
                    System.out.println(Thread.currentThread().getName() + "打印：" + i);
                    i++;
                    if (i < 100){
                        try{
                            wait(); // 释放锁
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }else {
                        break;
                    }
                }
            }
        }
    }
}
