package com.a3fun.learn.java.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortComparatorTest {

    public static void main(String[] args) {
        Teacher teacher1 = new Teacher(50);
        Teacher teacher2 = new Teacher(51);
        Teacher teacher3 = new Teacher(52);
        Teacher teacher4 = new Teacher(53);

        Student student1 = new Student(teacher1, "student 1");
        Student student2 = new Student(teacher2, "student 2");
        Student student3 = new Student(teacher3, "student 3");
        Student student4 = new Student(teacher4, "student 4");

        List<Student> studentList = new ArrayList<>();

        studentList.add(student1);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student2);
        System.out.println("排序前");
        studentList.forEach(System.out::println);
        System.out.println("根据老师年龄从大到小排序后：");
        Collections.sort(studentList, Comparator.comparingInt(Student::getTeacherAge).reversed());
        studentList.forEach(System.out::println);
    }

}
