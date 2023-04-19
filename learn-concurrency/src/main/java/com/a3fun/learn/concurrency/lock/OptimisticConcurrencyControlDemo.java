package com.a3fun.learn.concurrency.lock;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 乐观锁(CAS)
 */
public class OptimisticConcurrencyControlDemo implements Runnable{
    private static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) {
        OptimisticConcurrencyControlDemo ast = new OptimisticConcurrencyControlDemo();
        Thread thread1 = new Thread(ast);
        Thread thread = new Thread(ast);
        thread1.start();
        thread.start();
    }
    @Override
    public void run() {
        System.out.println("thread:"+Thread.currentThread().getName()+";flag:"+flag.get());
        if (flag.compareAndSet(true,false)){
            System.out.println(Thread.currentThread().getName()+";flag:"+flag.get());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag.set(true);
        }else{
            System.out.println("重试机制thread:"+Thread.currentThread().getName()+";flag:"+flag.get());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
        }

    }
}
