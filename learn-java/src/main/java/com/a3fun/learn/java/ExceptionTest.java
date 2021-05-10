package com.a3fun.learn.java;

/**
 * @author haixiangchen
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try{
            System.out.print("helloworld");
            System.exit(0);
        }finally {
            System.out.print(88);
        }
    }
}
