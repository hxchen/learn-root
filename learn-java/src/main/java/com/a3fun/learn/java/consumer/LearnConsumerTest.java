package com.a3fun.learn.java.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author chx
 * @Date: 2021/11/3 14:38
 */
public class LearnConsumerTest {

	public void eat(Consumer<Player> consumer) {
		List<Player> playerList = new ArrayList<>();
		playerList.add(new Player("zhangsan"));
		playerList.add(new Player("lisi"));
		playerList.forEach(consumer);
	}

	public static void main(String[] args) {
		LearnConsumerTest test = new LearnConsumerTest();
		test.eat(Player::selfIntroduction);
	}
}
