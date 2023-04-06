package com.a3fun.learn.java.factory_pattern.factory2;

import com.a3fun.learn.java.factory_pattern.Coffee;

/**
 * 工厂方法模式
 * 定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个，工厂方法让类把实例化推迟到了子类。
 * 场景延伸：不同地区咖啡工厂受制于环境、原料等因素的影响，制造出的咖啡种类有限。中国咖啡工厂仅能制造卡布奇诺、拿铁，而美国咖啡工厂仅能制造美式咖啡、拿铁。
 */
public abstract class AbstractCoffeeFactory {
    public abstract Coffee[] createCoffee();
}
