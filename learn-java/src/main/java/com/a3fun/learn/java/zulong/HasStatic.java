package com.a3fun.learn.java.zulong;

public class HasStatic {
    private static int x = 100;

    public static void main(String[] args) {
        HasStatic hsl = new HasStatic();
        hsl.x++;
        HasStatic hs2 = new HasStatic();
        hs2.x++;
        hsl  = new HasStatic();
        hsl.x++;
        HasStatic.x--;
        System.out.println("x = " + x);
    }
}
