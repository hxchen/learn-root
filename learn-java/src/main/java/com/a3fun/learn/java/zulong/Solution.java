package com.a3fun.learn.java.zulong;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

public class Solution {
    @Test
    public void Test1(){
        String str = new String ("hello");
        System.out.println(str.equals("hello"));
        System.out.println(str == "hello");
    }

    @Test
    public void Test3(){
        // 假设下面的函数foo 会被多线程调用， 那么让i, j, k 三个变量哪些因为线程间共享访问需要枷锁保护 （A）
//        int i = 0;
//        static int j = 0;
//        void foo(){
//            int k = 0;
//            i++;
//            j++;
//            k++;
//        }
        // A、i 和 j
        // B、i、j、k都需要
        // C、i
        // D、j和k
    }

    @Test
    public void Test9(){
        ArrayList list = new ArrayList(5);
        System.out.println("1");
        list.add(1);
        System.out.println("2");
        list.add(2);
        System.out.println("3");
        list.add(3);
        System.out.println("4");
        list.add(4);
        System.out.println("5");
        list.add(5);
        System.out.println("6");
        list.add(6);
    }

    @Test
    public void Test10(){

//        new BufferedWriter(new FileWriter("a.txt"));
        // 区分字符流和字节流 这么初始化是不对的
//        new BufferedReader(new FileInputStream("a.dat"));
//        new GZIPInputStream(new FileOutputStream("a.zip"));
//        new ObjectInputStream(new FileInputStream("a.dat"));
    }
}
