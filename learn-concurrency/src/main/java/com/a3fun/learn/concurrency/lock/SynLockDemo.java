package com.a3fun.learn.concurrency.lock;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class SynLockDemo {

    private int count;

    SynLockDemo(int count){
        this.count = count;
    }

    /**
     * 当 synchronized 修饰实例方法时，锁住的是对象
     * 其他线程不会获取到锁，也就不会执行调用方法
     * @throws InterruptedException
     */
    public synchronized void addOne() throws InterruptedException {
        while (true){
            // 持续占有锁
            count += 1;
            System.out.println(Thread.currentThread().getName() + " 执行 + 1");
            Thread.sleep(1000);
            // 当一个 synchronized 调用另一个 synchronized 方法时候, 是可以获取锁执行的，因为本线程已经获取到了对象锁
            addThree();
        }
    }
    /**
     * 当 synchronized 修饰实例方法时，锁住的是对象
     * 其他线程不会获取到锁，也就不会执行调用方法
     * @throws InterruptedException
     */
    public synchronized void addTwo() throws InterruptedException {
        while (true){
            // 持续占有锁
            count += 2;
            System.out.println(Thread.currentThread().getName() + " 执行 + 2");
            Thread.sleep(1000);
        }

    }

    /**
     * 当 synchronized 修饰实例方法时，锁住的是对象, 在该 synchronized 方法里还可以继续调用其他 synchronized方法。
     */
    public synchronized void addThree(){
        count += 3;
        System.out.println(Thread.currentThread().getName() + " 执行 + 3");
    }


    public static void main(String[] args) {
        SynLockDemo synLockDemo = new SynLockDemo(0);
        ThreadFactory threadFactory = new NameTreadFactory();
        ExecutorService executorService = new ThreadPoolExecutor(2, 3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1000), threadFactory);
        // 创建线程任务调用实例方法
        executorService.execute(()->{
            try {
                synLockDemo.addOne();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        // 创建线程任务调用实例方法
        executorService.execute(()->{
            try {
                synLockDemo.addTwo();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }

    static class NameTreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            return t;
        }
    }

}
