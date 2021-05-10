package com.a3fun.learn.java;

/**
 * @author haixiangchen
 */
public class HasStatic {
    private static int x = 100;

    public static void main(String[] args) {
        HasStatic hsl = new HasStatic();
        hsl.x++; // 编译可以通过，但是不符合规范
        HasStatic hs2 = new HasStatic();
        hs2.x++; // 编译可以通过，但是不符合规范
        hsl = new HasStatic();
        hsl.x++; // 编译可以通过，但是不符合规范
        HasStatic.x--;
        System.out.println("x = " + x);
    }
}
