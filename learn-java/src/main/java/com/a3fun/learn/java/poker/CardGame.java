package com.a3fun.learn.java.poker;

import java.util.List;

public class CardGame {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("Initial deck:");
        printDeck(deck);

        deck.shuffle();
        System.out.println("\nShuffled deck:");
        printDeck(deck);

        int numCardsToDeal = 5;
        List<Card> dealtCards = deck.deal(numCardsToDeal);
        System.out.println("\nDealt cards (" + numCardsToDeal + " cards):");
        for (Card card : dealtCards) {
            System.out.println(card);
        }

        System.out.println("\nRemaining deck:");
        printDeck(deck);
    }

    private static void printDeck(Deck deck) {
        for (Card card : deck.getCards()) {
            System.out.println(card);
        }
    }
}
