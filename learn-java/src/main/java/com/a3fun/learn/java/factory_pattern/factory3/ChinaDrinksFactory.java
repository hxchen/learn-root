package com.a3fun.learn.java.factory_pattern.factory3;

import com.a3fun.learn.java.factory_pattern.*;

public class ChinaDrinksFactory implements AbstractDrinksFactory{
    @Override
    public Coffee createCoffee() {
        // TODO Auto-generated method stub
        return new Latte();
    }

    @Override
    public Tea createTea() {
        // TODO Auto-generated method stub
        return new MilkTea();
    }

    @Override
    public Sodas createSodas() {
        // TODO Auto-generated method stub
        return null;
    }
}
