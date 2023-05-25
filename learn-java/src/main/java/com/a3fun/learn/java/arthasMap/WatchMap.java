package com.a3fun.learn.java.arthasMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Arthas 查看类属性变量值
 * watch com.a3fun.learn.java.arthasMap.WatchMap * 'target' -x 3
 */
public class WatchMap {
    private HashMap<Integer, Map<Integer,Student>> map = new HashMap<>();
    public void put(int key, Student student){
        HashMap<Integer, Student> innerMap = new HashMap<>();
        innerMap.put(student.getId(), student);
        map.put(key, innerMap);
    }

    public HashMap<Integer, Map<Integer, Student>> getMap() {
        return map;
    }

    public static void main(String[] args) throws InterruptedException {
        WatchMap obj = new WatchMap();
        obj.put(1, new Student(1000, 18, "One"));
        while (true){
            System.out.println("Map 大小："+ obj.getMap().size());
            Thread.sleep(1000L);
        }
    }
}
