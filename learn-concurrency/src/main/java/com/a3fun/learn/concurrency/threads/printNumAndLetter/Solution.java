package com.a3fun.learn.concurrency.threads.printNumAndLetter;

public class Solution {
    private boolean flag;
    private int count;

    public synchronized void printNum() {
        for (int i = 0; i < 26; i++) {
            while (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            flag = !flag;
            System.out.print(++count);
            System.out.print(++count);
            notify();
        }
    }

    public synchronized void printLetter() {
        for (int i = 0; i < 26; i++) {
            while (!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            flag = !flag;
            System.out.print((char) (65 + i));
            notify();
        }
    }

    public static void main(String[] args) {

        Solution turnsPrint2 = new Solution();

        new Thread(turnsPrint2::printNum).start();

        new Thread(turnsPrint2::printLetter).start();
    }
}
