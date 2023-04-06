package com.a3fun.learn.java.common;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * Integer 缓存机制
     * Integer默认在-128~127之间
     */
    @Test
    public void Test1(){
        Integer a = 10;
        Integer b = 10;
        Integer c = 129;
        Integer d = 129;
        Assert.assertTrue(a == b);
        Assert.assertTrue( c != d);
    }
}
