package com.a3fun.learn.concurrency.threads.tenThreadSum;

/**
 * 编写10个线程，第一个线程从1加到10，第二个线程从11加20…第十个线程从91加到100，最后再把10个线程结果相加。
 */
public class Solution {
    static class SumThread extends Thread{
        int weight = 0;
        int sum = 0;
        SumThread(int weight){
            this.weight = weight;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                sum += weight * 10 + i;
            }
        }
    }

    public static void main(String[] args) {
        int total = 0;
        for(int i = 0; i < 10; i++){
            SumThread sumThread = new SumThread(i);
            sumThread.start();
            try{
                sumThread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            total += sumThread.sum;
        }
        System.out.println("total : " + total);
    }
}
