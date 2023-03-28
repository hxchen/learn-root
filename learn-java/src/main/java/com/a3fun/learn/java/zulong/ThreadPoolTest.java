package com.a3fun.learn.java.zulong;

public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ThreadPool();
        for (int i = 0; i < 10; i++){
            Task runnable = new Task(i, i % 2 + 1);
            pool.AddTask(runnable);

        }
        pool.run();
        Thread.sleep(5000);
        pool.shutDown();
    }
}
