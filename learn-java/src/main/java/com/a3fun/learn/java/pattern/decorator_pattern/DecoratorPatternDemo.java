package com.a3fun.learn.java.decorator_pattern;

/**
 * 定义
 * 装饰模式是在不必改变原类和使用继承的情况下，动态地扩展一个对象的功能。它是通过创建一个包装对象，也就是装饰来包裹真实的对象
 * 使用场景
 * 需要在运行时动态的给一个对象增加额外的职责时候
 * 需要给一个现有的类增加职责，但是又不想通过继承的方式来实现的时候（应该优先使用组合而非继承），或者通过继承的方式不现实的时候（可能由于排列组合产生类爆炸的问题）。
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
