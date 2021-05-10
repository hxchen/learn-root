package com.a3fun.learn.java;

/**
 * @author haixiangchen
 */
public class ThreadExample extends Thread{
    @Override
    public void run() {
       try{
           Thread.sleep(1000);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
       System.out.print("run ");
    }

    public static void main(String[] args) {
        ThreadExample example = new ThreadExample();
        example.run();
        System.out.print("main ");
    }
}
