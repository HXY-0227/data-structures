package com.ooad.proxy.staticproxy;

public class Test {
    public static void main(String[] args) {
        //目标对象
        HelloService target = new HelloServiceImpl();
        target.sayHello();

        //代理对象
        HelloService proxy = new HelloServiceProxy(target);
        proxy.sayHello();

    }
}
