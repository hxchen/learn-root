package com.a3fun.learn.java;

/**
 * 基本数据类型（也称原始数据类型） ：byte,short,char,int,long,float,double,boolean。他们之间的比较，应用双等号（==）,比较的是他们的值。
 * 引用数据类型：当他们用（==）进行比较的时候，比较的是他们在内存中的存放地址（确切的说，是堆内存地址）。
 * @author haixiangchen
 */
public class EqualsTest {
    public static void main(String[] args) {
        String str = new String("hello");
        System.out.println(str.equals("hello"));
        System.out.println(str == "hello");
    }
}
