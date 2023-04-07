package com.a3fun.learn.concurrency.threads.printNumAndLetter;

/**
 * 写两个线程，一个线程打印1~ 52，另一个线程打印A~Z，打印顺序是12A34B…5152Z
 */
public class TakeTurnsPrint {
    private boolean flag;
    private int count;
    public synchronized void printNum(){
        for (int i = 0; i < 26; i++){
            while (flag){
                notify();
                flag = !flag;
                System.out.print(++count);
                System.out.print(++count);
            }
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void printLetter(){
        for (int i = 65; i <= 90; i++){
            while (!flag){
                notify();
                flag = !flag;
                System.out.print((char)i);
            }
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TakeTurnsPrint takeTurnsPrint = new TakeTurnsPrint();
        takeTurnsPrint.flag = true;
        new Thread(() -> takeTurnsPrint.printNum()).start();
        new Thread(() -> takeTurnsPrint.printLetter()).start();
    }
}
