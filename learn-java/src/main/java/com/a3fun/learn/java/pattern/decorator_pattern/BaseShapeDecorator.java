package com.a3fun.learn.java.decorator_pattern;


/**
 * 装饰模式是在不必改变原类和使用继承的情况下，动态地扩展一个对象的功能。它是通过创建一个包装对象，也就是装饰来包裹真实的对象
 * 实现了 Shape 接口的抽象装饰类。
 * @author haixiangchen
 */
public abstract class BaseShapeDecorator implements Shape{
    protected Shape decoratedShape;
    public BaseShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }
    @Override
    public void draw(){
        decoratedShape.draw();
    }
}
