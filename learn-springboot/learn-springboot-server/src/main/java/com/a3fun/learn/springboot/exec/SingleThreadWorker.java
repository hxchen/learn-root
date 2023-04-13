package com.a3fun.learn.springboot.exec;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class SingleThreadWorker implements Runnable{
    private ExecutorService exec = Executors.newSingleThreadExecutor();

    @Override
    public void run() {
        try {
            execute();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void start(){
        exec.execute(this);
    }
    protected abstract void execute() throws InterruptedException;
}
