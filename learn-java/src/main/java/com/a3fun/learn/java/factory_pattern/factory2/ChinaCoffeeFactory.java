package com.a3fun.learn.java.factory_pattern.factory2;

import com.a3fun.learn.java.factory_pattern.Cappuccino;
import com.a3fun.learn.java.factory_pattern.Coffee;
import com.a3fun.learn.java.factory_pattern.Latte;

public class ChinaCoffeeFactory extends AbstractCoffeeFactory{
    @Override
    public Coffee[] createCoffee() {
        return new Coffee[]{new Cappuccino(), new Latte()};
    }
}
