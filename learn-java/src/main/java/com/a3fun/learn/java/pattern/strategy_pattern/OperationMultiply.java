package com.a3fun.learn.java.pattern.strategy_pattern;

public class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
