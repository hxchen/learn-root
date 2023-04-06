package com.a3fun.learn.java.factory_pattern.factory2;

import com.a3fun.learn.java.factory_pattern.Coffee;


public class FactoryTest {
    static void print(Coffee[] c){
        for (Coffee coffee : c) {
            System.out.println(coffee.getName());
        }
    }
    public static void main(String[] args) {
        AbstractCoffeeFactory chinaCoffeeFactory = new ChinaCoffeeFactory();
        Coffee[] chinaCoffees = chinaCoffeeFactory.createCoffee();
        System.out.println("中国咖啡工厂可以生产的咖啡有：");
        print(chinaCoffees);

        AbstractCoffeeFactory americaCoffeeFactory = new AmericaCoffeeFactory();
        Coffee[] americaCoffees = americaCoffeeFactory.createCoffee();
        System.out.println("美国咖啡工厂可以生产的咖啡有：");
        print(americaCoffees);
    }
}
