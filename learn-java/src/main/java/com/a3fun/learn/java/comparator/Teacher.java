package com.a3fun.learn.java.comparator;

public class Teacher {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                '}';
    }
}
