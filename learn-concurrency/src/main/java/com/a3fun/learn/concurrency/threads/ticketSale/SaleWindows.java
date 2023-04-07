package com.a3fun.learn.concurrency.threads.ticketSale;

public class SaleWindows extends Thread{
    private Ticket ticket;

    public SaleWindows(String name, Ticket ticket){
        super(name);
        this.ticket = ticket;
    }

    @Override
    public void run() {
        super.run();
        ticket.sale();
    }
}
