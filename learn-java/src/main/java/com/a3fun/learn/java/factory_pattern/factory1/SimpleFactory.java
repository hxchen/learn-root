package com.a3fun.learn.java.factory_pattern.factory1;

import com.a3fun.learn.java.factory_pattern.Americano;
import com.a3fun.learn.java.factory_pattern.Cappuccino;
import com.a3fun.learn.java.factory_pattern.Coffee;
import com.a3fun.learn.java.factory_pattern.Latte;

/**
 * 简单工厂实际不能算作一种设计模式，它引入了创建者的概念，将实例化的代码从应用代码中抽离，在创建者类的静态方法中只处理创建对象的细节，后续创建的实例如需改变，只需改造创建者类即可，
 *
 * 但由于使用静态方法来获取对象，使其不能在运行期间通过不同方式去动态改变创建行为，因此存在一定局限性。
 */
public class SimpleFactory {
    public static Coffee createInstance(String type){
        if("americano".equals(type)){
            return new Americano();
        }else if("cappuccino".equals(type)){
            return new Cappuccino();
        }else if("latte".equals(type)){
            return new Latte();
        }else{
            throw new RuntimeException("type["+type+"]类型不可识别，没有匹配到可实例化的对象！");
        }
    }

    public static void main(String[] args) {
        Coffee latte = SimpleFactory.createInstance("latte");
        System.out.println("创建的咖啡实例为:" + latte.getName());
        Coffee cappuccino = SimpleFactory.createInstance("cappuccino");
        System.out.println("创建的咖啡实例为:" + cappuccino.getName());
    }
}
