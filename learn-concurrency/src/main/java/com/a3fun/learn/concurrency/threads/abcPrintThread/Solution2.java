package com.a3fun.learn.concurrency.threads.abcPrintThread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.start();
    }

    public void start() {
        Lock lock = new ReentrantLock();
        Count count = new Count(0);
        new Thread(new PrintThread("A", lock, count, 0)).start();
        new Thread(new PrintThread("B", lock, count, 1)).start();
        new Thread(new PrintThread("C", lock, count, 2)).start();
    }

    class Count {
        int count;
        Count(int count){
            this.count = count;
        }
    }
    class PrintThread implements Runnable{
        private String name;
        private Lock lock;
        private Count count;
        private Integer flag;

        PrintThread(String name, Lock lock, Count count, Integer flag){
            this.name = name;
            this.lock = lock;
            this.count = count;
            this.flag = flag;
        }

        public  final int TIMES = 9;
        @Override
        public void run() {
            while (true){
                lock.lock();
                if (count.count >= TIMES){
                    lock.unlock();
                    return;
                }
                if (count.count%3 == flag){
                    System.out.print(name);
                    count.count++;
                }
                lock.unlock();
            }
        }
    }
}
