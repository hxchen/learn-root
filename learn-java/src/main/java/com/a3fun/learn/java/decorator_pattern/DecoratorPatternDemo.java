package com.a3fun.learn.java.decorator_pattern;

/**
 * 使用 RedShapeDecorator 来装饰 Shape 对象。
 * @author haixiangchen
 */
public class DecoratorPatternDemo {

    public static void main(String[] args) {

        Shape circle = new Circle();
        BaseShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        BaseShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
