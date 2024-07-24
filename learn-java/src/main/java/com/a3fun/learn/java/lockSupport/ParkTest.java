package com.a3fun.learn.java.lockSupport;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class ParkTest {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        LockSupport.unpark(thread);
        System.out.println("begin ");
        LockSupport.park();
        System.out.println("end");
        LockSupport.park();
        System.out.println("end2");
    }



}
