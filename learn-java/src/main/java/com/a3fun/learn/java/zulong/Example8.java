package com.a3fun.learn.java.zulong;

public class Example8 {
    public static void main(String[] args) {
        try{
            System.out.println("helloworld");
            System.exit(0);
        }finally {
            // 根本不会执行啦
            System.out.println("8888888888");
        }
    }
}
