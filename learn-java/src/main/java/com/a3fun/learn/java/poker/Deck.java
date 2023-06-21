package com.a3fun.learn.java.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 一副扑克牌
 */
public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (int value = 1; value <= 13; value++) {
                Card card = new Card(suit, value);
                cards.add(card);
            }
        }
    }

    /**
     * 使用Fisher-Yates洗牌算法（也称为Knuth洗牌算法），通过交换牌的位置来打乱牌堆的顺序。
     * 从最后一张牌开始，依次与前面的牌进行交换，直到第一张牌。
     * 每次交换时，它使用Random类生成一个介于0和当前索引之间的随机数，然后将当前牌与随机位置的牌进行交换。
     * 这样就可以确保每张牌在洗牌后的位置是随机的
     */
    public void shuffle() {
        Random rand = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    /**
     * 发牌，它从牌堆中抽取一定数量的牌并返回。该函数接受一个整数参数numCards，表示要抽取的牌的数量。
     * 在deal()函数中，我们使用一个循环来依次从牌堆的末尾取出牌，并将其添加到一个新的列表中。
     * 每次迭代时，我们都会检查牌堆是否为空。如果牌堆不为空，我们就将最后一张牌（即牌堆中的最后一个元素）从牌堆中移除并添加到dealtCards列表中；否则，我们跳出循环。
     * 最后，deal()函数返回dealtCards列表，其中包含了抽取的牌。如果牌堆中的牌数量不足numCards，那么返回的列表可能会比请求的数量少。你可以遍历返回的列表来查看发出的牌。
     * @param numCards
     * @return
     */
    public List<Card> deal(int numCards) {
        List<Card> dealtCards = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            if (!cards.isEmpty()) {
                dealtCards.add(cards.remove(cards.size() - 1));
            } else {
                break;
            }
        }
        return dealtCards;
    }

    public List<Card> getCards() {
        return cards;
    }
}
