package com.a3fun.learn.concurrency.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 互斥锁
 */
public class Mutex {

    private final Sync sync = new Sync();
    public void lock(){
        sync.tryAcquire(1);
    }

    public void unlock(){
        sync.tryRelease(1);
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }

    private static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }
}
