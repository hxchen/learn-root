package com.a3fun.learn.concurrency.thread_pool;

import java.util.Date;

public class Task implements Runnable{
    private String name;
    private int count;
    public Task(String name){
        this.name = name;
        this.count = 1;
    }

    @Override
    public void run() {
        int currentCount = count;
        count++;
        System.out.println(Thread.currentThread().getName() + " name = " + name + ", 任務開始 第<" + currentCount +">次 startTime = " + new Date());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " name = " + name + ", 任務結束 第<" + currentCount + ">次 endTime = " + new Date());
    }
}
