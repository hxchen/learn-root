package com.a3fun.learn.java;

/**
 * @author haixiangchen
 */
public class ReferenceExample {
    String str = new String("good");
    char[] ch = {'a', 'b','c'};

    public static void main(String[] args) {
        ReferenceExample ex = new ReferenceExample();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str+" and ");
        System.out.print(ex.ch);
    }

    private void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }
}
