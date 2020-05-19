package com.ooad.proxy.cglib;

public class Test {
    public static void main(String[] args) {
        MyCglibProxyFactory factory = new MyCglibProxyFactory();

        StudentService target = new StudentService();

        StudentService proxy = (StudentService)factory.getInstance(target.getClass());

        proxy.delete(1);
        proxy.update(18);
    }
}
