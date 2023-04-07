package com.a3fun.learn.concurrency.threads;

public class JoinTest {
    public static class PrintThread extends Thread{

        PrintThread(String name){
            super(name);
        }

        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                System.out.println(getName() + " : " + i);
            }
        }
    }

    public static void main(String[] args){

        PrintThread t1 = new PrintThread("a");
        PrintThread t2 = new PrintThread("b");
        PrintThread t3 = new PrintThread("c");

        try {

            t1.start();
            t1.join();

            t2.start();
            t2.join();

            t3.start();
            t3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
