package com.a3fun.learn.concurrency.threads.producrerAndConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Solution3 {
    private int count = 0;

    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {

        Solution3 solution3 = new Solution3();
        for (int i = 1; i <= 5; i++) {
            new Thread(solution3.new Producer(), "生产者-" + i).start();
            new Thread(solution3.new Consumer(), "消费者-" + i).start();
        }
    }

    class Producer implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    queue.put(1);
                    System.out.println("生产者 " + Thread.currentThread().getName() + " 总共有 " + ++count + " 个资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.take();
                    System.out.println("消费者 " + Thread.currentThread().getName() + " 总共有 " + --count + " 个资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
