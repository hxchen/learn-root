package com.a3fun.learn.springboot.exec;

import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
@Component
public class UserTaskExecutors {
    public static ExecutorService executorService = null;
    public static int CPU_CORE_SIZE = 4;
    {
        executorService = new ThreadPoolExecutor(CPU_CORE_SIZE, CPU_CORE_SIZE, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10*1000*100), new NameThreadFactory());
    }

    class NameThreadFactory implements ThreadFactory{
        private final AtomicInteger mThreadNum = new AtomicInteger(1);
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            return t;
        }
    }
}
