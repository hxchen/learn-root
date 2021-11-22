package com.a3fun.learn.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chx
 * @Date: 2021/9/23 16:21
 */
public class LearnStreamTest {
	public static void main(String[] args) {
		learnMap();
	}
	public static void learnMap(){
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// 获取对应的平方数
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		squaresList.stream().sorted().forEach(System.out::println);
	}
}
