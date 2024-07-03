package com.a3fun.learn.java.utils;

public class RandomUtil {
    public static int random(int[] weight){
        int sum = 0;
        for (int i : weight) {
            sum += i;
        }
        int random = (int) (Math.random() * sum);
        for (int i = 0; i < weight.length; i++) {
            random -= weight[i];
            if (random < 0) {
                return i;
            }
        }
        return weight.length - 1;
    }

    public static void main(String[] args) {
        int[] weight = {1, 2, 3, 4, 5};
        int[] count = new int[weight.length];
        for (int i = 0; i < 1000000; i++) {
            int random = random(weight);
            count[random]++;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(i + " : " + count[i]);
        }
    }
}
