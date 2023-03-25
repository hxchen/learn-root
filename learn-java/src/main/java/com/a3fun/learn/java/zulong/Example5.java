package com.a3fun.learn.java.zulong;

/**
 * 易错题
 */
public class Example5 extends Thread{
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        }catch ( InterruptedException e){
            e.printStackTrace();
        }
        System.out.print("run ");
    }

    public static void main(String[] args) {
        Example5 example5 = new Example5();
        example5.run();
        System.out.print("main");
        
    }
}
