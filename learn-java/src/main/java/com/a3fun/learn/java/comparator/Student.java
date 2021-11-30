package com.a3fun.learn.java.comparator;

public class Student {
    private Teacher teacher;
    private String name;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(Teacher teacher, String name) {
        this.teacher = teacher;
        this.name = name;
    }

    public int getTeacherAge() {
        return teacher.getAge();
    }
    @Override
    public String toString() {
        return "Student{" +
                "teacher=" + teacher +
                ", name='" + name + '\'' +
                '}';
    }
}
