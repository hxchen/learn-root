package com.a3fun.learn.java;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1.HashMap1.8引入红黑树,插入数据,扩容时机都有变化。
 * 2. 在多线程条件下，容易导致死循环，具体表现为CPU使用率100%。因此多线程环境下保证 HashMap 的线程安全性，主要有如下几种方法：
 * 使用 java.util.Hashtable 类，此类是线程安全的。
 * 使用 java.util.concurrent.ConcurrentHashMap，此类是线程安全的。
 * 使用 java.util.Collections.synchronizedMap() 方法包装 HashMap object，得到线程安全的Map，并在此Map上进行操作。
 *
 * @author haixiangchen
 */
public class MapDemo {

    /**
     * 容量测试
     * @param initCapacity 入参容量
     * @return 实际容量
     * @throws Exception
     */
    public static int capacityTest(int initCapacity) throws Exception {

//        Map<String, String> map = new Hashtable<>();
//        Map<String, String> map = new ConcurrentHashMap<>();
        Map<String, String> map = new HashMap<String, String>(initCapacity);

        // 通过反射获取容量变量capacity,并调用map对象
        Method capacity = map.getClass().getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        Integer realCapacity = (Integer) capacity.invoke(map);
        System.out.println("入参容量为" + initCapacity + "时，实际容量为" + realCapacity);
        return realCapacity;
    }
    /**
     * 临界值测试
     * @throws Exception
     */
    public static void thresholdTest() throws Exception {

        Map<String, String> map = new HashMap<String, String>();

        // 获取map扩容时临界阈值  阈值 = 容量 * 加载因子
        // 默认容量 为16，加载因子 默认为0.75
        Field threshold = map.getClass().getDeclaredField("threshold");
        Field size = map.getClass().getDeclaredField("size");
        Method capacity = map.getClass().getDeclaredMethod("capacity");

        threshold.setAccessible(true);
        size.setAccessible(true);
        capacity.setAccessible(true);

        // 未存放对象时，各项值测试
        System.out.println("start:临界值" + threshold.get(map));
        System.out.println("start:size" + size.get(map));
        System.out.println("start:容量" + capacity.invoke(map));

        // 临界值、容量测试
        for (int i=1; i<26; i++) {
            map.put(String.valueOf(i), i + "**");
            if (i == 11 || i == 12 || i == 13 || i == 23 || i == 24 || i == 25) {
                System.out.println("第" + i + "个对象, size为" + size.get(map) + ", 临界值为" + threshold.get(map) + ", 容量为" + capacity.invoke(map));
            }
        }
    }
    public static void main(String[] args) throws Exception {
//        capacityTest(1);
//        capacityTest(2);
//        capacityTest(3);
//        capacityTest(4);
//        capacityTest(7);
//        capacityTest(15);
//        capacityTest(21);
//        capacityTest(1500000000);
//        thresholdTest();
    }
}
