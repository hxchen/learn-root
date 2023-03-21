package com.a3fun.learn.java.beautyoflambda;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.function.*;

public class LambdaTest {
    /**
     * Predicate 判断真假
     */
    @Test
    public void PredicateTest(){
        Predicate<Integer> predicate = x -> x > 18;
        System.out.println(predicate.test(17));
        System.out.println(predicate.test(18));
        System.out.println(predicate.test(19));
    }

    /**
     * Consumer 消费消息
     */
    @Test
    public void ConsumerText(){
        Consumer<String> consumer = System.out::println;
        consumer.accept("Consumer 可以利用accept 方法输出一个值");
    }

    /**
     * Function 可以映射
     */
    @Test
    public void FunctionTest(){
        Function<Integer, String> function = Integer::toBinaryString;
        System.out.println(function.apply(10));
    }

    /**
     * 生产消息
     */
    @Test
    public void SupplierTest(){
        Supplier<Integer> supplier =
                () -> Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println(supplier.get());
    }

    /**
     * 一元操作
     */
    @Test
    public void UnaryOperatorTest(){
        UnaryOperator<Boolean> unaryOperator =  reverse-> !reverse;
        Boolean apply2 = unaryOperator.apply(true);
        System.out.println(apply2);
    }

    /**
     * 二元操作
     */
    @Test
    public void BinaryOperatorTest(){
        BinaryOperator<Integer> operator = (x, y) -> x * y;
        Integer integer = operator.apply(2, 3);
        System.out.println(integer);
    }
}
