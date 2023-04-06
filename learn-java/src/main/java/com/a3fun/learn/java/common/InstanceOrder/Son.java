package com.a3fun.learn.java.common.InstanceOrder;

public class Son extends Parent{
    {
        System.out.println("子类非静态代码块");
    }
    static {
        System.out.println("子类静态块");
    }

    public Son(){
        System.out.println("子类构造器");
    }
}
