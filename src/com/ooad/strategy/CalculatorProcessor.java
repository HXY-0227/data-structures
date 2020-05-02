package com.ooad.strategy;

/**
 * 一个处理类，负责把我们的接口和实现类连接起来，这里可以定义好一些共同的流程啊之类的
 *
 * @since 2020-05-02
 * @author HXY
 */
public class CalculatorProcessor{
    private final int num1;
    private final int num2;
    private final CalculatorStrategy calculatorStrategy;

    public CalculatorProcessor(int num1, int num2, CalculatorStrategy calculatorStrategy) {
        this.num1 = num1;
        this.num2 = num2;
        this.calculatorStrategy = calculatorStrategy;
    }

    public double calculate() {
        return calculatorStrategy.calculate(num1, num2);
    }
}
