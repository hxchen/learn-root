package com.a3fun.learn.java.zulong;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 构造一个线程池，满足以下条件：
 * 1. 线程池包含两种线程,优先级1的线程2个，优先级2的线程3个
 * 2. 提供向线程池添加任务的方法，每个任务也有自己的优先级
 * 3. 对应优先级的线程池只处理对应优先级的任务
 */
public class ThreadPool implements Runnable{

    ExecutorService executor1 = Executors.newFixedThreadPool(2);
    ExecutorService executor2 = Executors.newFixedThreadPool(3);
    private  PriorityBlockingQueue<Runnable>  priorityBlockingQueue1 = new PriorityBlockingQueue<>();
    private  PriorityBlockingQueue<Runnable>  priorityBlockingQueue2 = new PriorityBlockingQueue<>();
    public void AddTask(Runnable runnable){
        if (runnable instanceof Task){
            if (((Task) runnable).getPriority() == 1){
                priorityBlockingQueue1.offer(runnable);
            } else if (((Task) runnable).getPriority() == 2){
                priorityBlockingQueue2.offer(runnable);
            }else{
                System.out.println(((Task) runnable).getPriority());
            }
        }
    }

    @Override
    public void run() {
        while (!priorityBlockingQueue1.isEmpty()){
            executor1.execute(priorityBlockingQueue1.poll());
        }
        while (!priorityBlockingQueue2.isEmpty()){
            executor2.execute(priorityBlockingQueue2.poll());
        }

    }

    public void shutDown(){
        System.out.println("线程池关闭");
        executor1.shutdown();
        executor2.shutdown();
    }
}
