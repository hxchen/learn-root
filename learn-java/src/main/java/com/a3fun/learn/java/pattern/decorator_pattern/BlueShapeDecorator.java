package com.a3fun.learn.java.decorator_pattern;

/**
 * 扩展了 ShapeDecorator 类的实体装饰类。
 * @author haixiangchen
 */
public class BlueShapeDecorator extends BaseShapeDecorator {
    public BlueShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        super.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Blue");
    }
}
