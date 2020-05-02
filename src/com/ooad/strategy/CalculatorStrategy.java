package com.ooad.strategy;

/**
 * 定义策略接口
 *
 * @since 2020-05-02
 * @author HXY
 */
@FunctionalInterface
public interface CalculatorStrategy {
    double calculate(int num1, int num2);
}
