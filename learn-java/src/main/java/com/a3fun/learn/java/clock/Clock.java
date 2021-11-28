package com.a3fun.learn.java.clock;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 高并发下对System.currentTimeMillis()的优化
 * @author haixiangchen
 */
public class Clock {
    private static final int precision = 1;
    private static final Clock instance = new Clock(precision);
    private final AtomicLong now;
    /**
     * 精度 单位毫秒
     *
     * @param precision
     */
    private Clock(long precision) {

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(1, namedThreadFactory);
        now = new AtomicLong(System.currentTimeMillis());

        pool.scheduleAtFixedRate(() -> {
            now.set(System.currentTimeMillis());
//            System.out.println("更新时间:"+now.get());
        },0, 1, TimeUnit.MILLISECONDS);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            pool.shutdown();
            System.out.println("clock shutdown");
        }));
    }

    public static Clock getInstance() {
        return instance;
    }

    public long now() {
        return now.get();
    }

    /**
     * 验证缓存时间的耗时
     */
   @Test
	public void TestQuick() {
        long start1 = Clock.getInstance().now();
        for (int i = 0; i < Integer.MAX_VALUE; i++){
            Clock.getInstance().now();
        }
        System.out.println("Clock cost time:" + (Clock.getInstance().now() - start1));

        long start2 = Clock.getInstance().now();
        for (int i = 0; i < Integer.MAX_VALUE; i++){
            System.currentTimeMillis();
        }
        System.out.println("Sys cost time:" + (Clock.getInstance().now() - start2));
	}

}
