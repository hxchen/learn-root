package com.a3fun.learn.java.match;

public class Player {
    int playerId;
    int power;

    public Player(int playerId, int power) {
        this.playerId = playerId;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", power=" + power +
                '}';
    }
}
