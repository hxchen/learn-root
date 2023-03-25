package com.a3fun.learn.java.zulong.priority_thread;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class MyRunnable  {

    /**
     * 创建1000个任务，奇数任务用优先级2的线程处理，偶数任务用优先级1的线程处理
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException{
        PriorityThreadPoolExecutor executor = new PriorityThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, 4, new ThreadPoolExecutor.CallerRunsPolicy());
        executor.asyncExecute(new Task(31), PriorityThreadPoolExecutor.TaskPriority.LOW);
        executor.asyncExecute(new Task(32), PriorityThreadPoolExecutor.TaskPriority.LOW);

        executor.asyncExecute(new Task(21), PriorityThreadPoolExecutor.TaskPriority.MEDIUM);
        executor.asyncExecute(new Task(33));
        executor.asyncExecute(new Task(22), PriorityThreadPoolExecutor.TaskPriority.MEDIUM);
        executor.asyncExecute(new Task(34));

        executor.asyncExecute(new Task(11), PriorityThreadPoolExecutor.TaskPriority.HIGH);
        executor.asyncExecute(new Task(12), PriorityThreadPoolExecutor.TaskPriority.HIGH);
        executor.asyncExecute(new Task(13), PriorityThreadPoolExecutor.TaskPriority.HIGH);

    }
    private static class Task implements Runnable {
        private final int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(2));
            System.out.println("run-task: " + i + ", thread-name: " + Thread.currentThread().getName());
        }
    }
}
