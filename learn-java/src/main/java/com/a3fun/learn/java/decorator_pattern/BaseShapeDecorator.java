package com.a3fun.learn.java.decorator_pattern;


/**
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
