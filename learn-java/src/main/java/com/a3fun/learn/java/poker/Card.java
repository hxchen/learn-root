package com.a3fun.learn.java.poker;

/**
 * 一张扑克牌
 */
public class Card {
    /**
     * 花色
     */
    private Suit suit;
    /**
     * 牌面值
     */
    private int value;

    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        String cardValue;
        if (value >= 2 && value <= 10) {
            cardValue = String.valueOf(value);
        } else {
            switch (value) {
                case 1:
                    cardValue = "A";
                    break;
                case 11:
                    cardValue = "J";
                    break;
                case 12:
                    cardValue = "Q";
                    break;
                case 13:
                    cardValue = "K";
                    break;
                default:
                    cardValue = "";
            }
        }

        return cardValue + " " + suit;
    }
}
