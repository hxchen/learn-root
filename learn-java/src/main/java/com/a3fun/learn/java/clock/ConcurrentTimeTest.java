package com.a3fun.learn.java.clock;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 不同线程获取时间戳实验
 * @author haixiangchen
 */
public class ConcurrentTimeTest {

    public static void showTime() {

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        //Common Thread Pool
        ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(2, namedThreadFactory);

        pool.scheduleAtFixedRate(()->{
            System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis());
        },
                0, 1, TimeUnit.MILLISECONDS);
        pool.scheduleAtFixedRate(()->{
                    System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis());
                },
                0, 3, TimeUnit.MILLISECONDS);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            pool.shutdown();
            System.out.println("shutdown");
        }));
    }

    public static void main(String[] args) {
        showTime();
    }
}
