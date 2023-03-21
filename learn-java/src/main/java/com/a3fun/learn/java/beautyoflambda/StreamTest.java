package com.a3fun.learn.java.beautyoflambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    public void CollectTest(){
        List<Student> studentList = Stream.of(
                new Student("孙悟空", 28, 1),
                new Student("孙悟饭", 3, 0),
                new Student("布罗利", 25, 1)
        ).collect(Collectors.toList());
        System.out.println(studentList);
    }

    /**
     * 过滤, 内部使用test accept 实现
     */
    @Test
    public void FilterTest(){
        List<Student> studentList = Stream.of(
                new Student("孙悟空", 28, 1),
                new Student("孙悟饭", 3, 0),
                new Student("布罗利", 25, 1)
        ).filter(student -> student.getStatus() == 1).collect(Collectors.toList());
        System.out.println(studentList);
    }

    /**
     * Map 可以转换
     */
    @Test
    public void MapTest(){
        List<String> studentList = Stream.of(
                new Student("孙悟空", 28, 1),
                new Student("孙悟饭", 3, 0),
                new Student("布罗利", 25, 1)
        ).map(Student::getName).collect(Collectors.toList());
        System.out.println(studentList);
    }

    /**
     * flatMap方法接受一个lambda表达式函数， 函数的返回值必须也是一个stream类型，flatMap方法最终会把所有返回的stream合并
     */
    @Test
    public void FlatMapTest(){
        List<Student> students1 = Stream.of(
                new Student("孙悟空", 28, 1),
                new Student("孙悟饭", 3, 0),
                new Student("布罗利", 25, 1)).collect(Collectors.toList());

        List<Student> students2 = Stream.of(
                new Student("布玛", 28, 1),
                new Student("龟仙人", 25, 1)).collect(Collectors.toList());

        List<Student> studentList = Stream.of(students1,students2).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(studentList);
    }

    @Test
    public void MaxTest(){
        List<Student> students = Stream.of(
                new Student("孙悟空", 28, 1),
                new Student("孙悟饭", 3, 0),
                new Student("布罗利", 25, 1)).collect(Collectors.toList());
        Optional<Student> maxAgeStudent = students.stream().max(Comparator.comparing(Student::getAge));
        System.out.println(maxAgeStudent.isPresent() ? maxAgeStudent.get() : "空值");
    }

    @Test
    public void ReduceTest(){
        Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
