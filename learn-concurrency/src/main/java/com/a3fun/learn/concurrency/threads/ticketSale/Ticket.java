package com.a3fun.learn.concurrency.threads.ticketSale;

public class Ticket {
    private int count = 0;
    Ticket(int count){
        this.count = count;
    }
    public void sale(){
        while (true){
            synchronized (this){
                if (count == 0){
                    System.out.println("ticket sold out");
                    break;
                }else {
                    System.out.println(Thread.currentThread().getName() + "卖出去一张票，剩下 " + --count + " 张票");
                }
                try {
                    Thread.sleep(200);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
