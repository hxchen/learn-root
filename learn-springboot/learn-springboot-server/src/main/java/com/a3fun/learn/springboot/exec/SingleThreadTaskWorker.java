package com.a3fun.learn.springboot.exec;

import com.a3fun.learn.springboot.world.WorldWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class SingleThreadTaskWorker<T> implements Runnable {
    private Logger LOGGER = LoggerFactory.getLogger(SingleThreadTaskWorker.class);
    private ConcurrentLinkedQueue<T> taskQueue = new ConcurrentLinkedQueue<>();
    private ExecutorService exec = Executors.newSingleThreadExecutor();

    private volatile Thread workerThread;

    @Override
    public void run() {
        Thread workerThread = Thread.currentThread();
        this.workerThread = workerThread;
        try{
            if (Thread.interrupted()){
                throw new InterruptedException();
            }
            T task = null;
            while ((task = taskQueue.poll()) != null){
                try{
                    execute(task);
                }catch (Throwable e){
                    LOGGER.error("throws exception", e);
                }
            }
        }catch (InterruptedException e){
            LOGGER.error("InterruptedException exception", e);
        }catch (Throwable e){
            LOGGER.error("throws exception", e);
        }
    }
    protected void addTask(T task){
        taskQueue.add(task);
    }

    protected abstract void execute(T task);
}
