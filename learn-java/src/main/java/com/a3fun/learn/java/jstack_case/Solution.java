package com.a3fun.learn.java.jstack_case;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 运行后
 * jps 获取进程
 * 可以jstack<进程id>查看
 */
public class Solution {
    public static Executor executor =  Executors.newFixedThreadPool(5);
    public static Object lock = new Object();

    public static void main(String[] args) {
        Task task1 = new Task();
        Task task2 = new Task();
        executor.execute(task1);
        executor.execute(task2);
    }

    static class Task implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                try {
                  lock.wait();
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
//                calculate();
            }
        }

        public void calculate(){
            int i = 0;
            while (true){
                i++;
            }
        }
    }
}
