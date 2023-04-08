package com.a3fun.learn.java.sorted_set_task;

import lombok.Data;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 演示SortedSet
 */
public class Solution {
    public static void main(String[] args) {
        SortedSet<Task> set = new TreeSet<>();
        set.add(new Task(1672502411000L, "Battle"));
        set.add(new Task(1672502401000L, "Move"));
        set.add(new Task(1672502406000L, "Select"));

        Iterator it = set.iterator();

        while (it.hasNext()) {
            Object element = it.next();
            System.out.println(element.toString());
        }
    }
    static class Task implements Comparable<Task> {
        private Long time;
        private String name;

        public Task(long time, String name){
            this.time = time;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "time=" + time +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Task o2) {
            return this.time.compareTo(o2.time);
        }
    }
}
