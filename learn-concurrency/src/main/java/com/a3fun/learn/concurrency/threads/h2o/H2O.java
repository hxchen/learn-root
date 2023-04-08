package com.a3fun.learn.concurrency.threads.h2o;


import java.util.concurrent.Semaphore;

public class H2O {
    private Semaphore hSema = new Semaphore(2);
    private Semaphore oSema = new Semaphore(0);
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSema.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hSema.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSema.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        oSema.release(2);
    }
}
