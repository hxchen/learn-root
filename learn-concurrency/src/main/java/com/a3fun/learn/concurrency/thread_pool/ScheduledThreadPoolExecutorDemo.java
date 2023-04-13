package com.a3fun.learn.concurrency.thread_pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 1; i++){
            Task worker = new Task("task-" + i);
            // 周期性执行，每5秒执行一次
            scheduledThreadPool.scheduleAtFixedRate(worker, 0,1, TimeUnit.SECONDS);
        }
//        Thread.sleep(10000);
//
//        System.out.println(Thread.currentThread().getName() + " Shutting down executor...");
//        // 关闭线程池
//        scheduledThreadPool.shutdown();
//        boolean isDone;
//        // 等待线程池终止
//        do {
//            isDone = scheduledThreadPool.awaitTermination(1, TimeUnit.DAYS);
//            System.out.println(Thread.currentThread().getName() + " awaitTermination...");
//        } while(!isDone);
//
//        System.out.println(Thread.currentThread().getName() + " Finished all threads");
    }

}
