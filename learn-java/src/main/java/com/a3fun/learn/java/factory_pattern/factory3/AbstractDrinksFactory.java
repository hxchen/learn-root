package com.a3fun.learn.java.factory_pattern.factory3;

import com.a3fun.learn.java.factory_pattern.Coffee;
import com.a3fun.learn.java.factory_pattern.Sodas;
import com.a3fun.learn.java.factory_pattern.Tea;


public interface AbstractDrinksFactory {
    /**
     * 制造咖啡
     * @return
     */
    Coffee createCoffee();

    /**
     * 制造茶
     * @return
     */
    Tea createTea();

    /**
     * 制造碳酸饮料
     * @return
     */
    Sodas createSodas();
}
