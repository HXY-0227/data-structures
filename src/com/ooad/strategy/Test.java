package com.ooad.strategy;

public class Test {
    public static void main(String[] args) {
        CalculatorProcessor processor = new CalculatorProcessor(3, 2, (num1, num2) -> num1 + num2);
        System.out.println(processor.calculate());
    }
}
