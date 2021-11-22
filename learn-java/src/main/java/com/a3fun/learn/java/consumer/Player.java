package com.a3fun.learn.java.consumer;

/**
 * @author chx
 * @Date: 2021/11/3 14:54
 */
public class Player {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player(String name) {
		this.name = name;
	}

	public void selfIntroduction() {
		System.out.println("My name is :" + name);
	}
}
