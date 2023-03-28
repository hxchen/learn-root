package com.a3fun.learn.java.thread_start_run;

public class Runner1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + " Runner1 :" + i);
        }
    }
}
