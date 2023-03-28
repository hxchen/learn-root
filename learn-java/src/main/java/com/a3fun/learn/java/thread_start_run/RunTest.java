package com.a3fun.learn.java.thread_start_run;

public class RunTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " Main Run");
        Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();
        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);
//        thread1.start();
//        thread2.start();
        thread1.run();
        thread2.run();
    }
}
