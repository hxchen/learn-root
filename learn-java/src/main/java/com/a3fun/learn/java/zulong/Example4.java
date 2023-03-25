package com.a3fun.learn.java.zulong;

public class Example4 extends Object{
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public static void main(String[] args) {
        Example4 ex = new Example4();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);
    }

    private void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }
}
