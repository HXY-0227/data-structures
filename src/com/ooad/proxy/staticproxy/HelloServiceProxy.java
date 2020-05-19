package com.ooad.proxy.staticproxy;

/**
 * 代理类
 *
 * @author HXY
 * @since 2020-5-9
 */
public class HelloServiceProxy implements HelloService{

    private HelloService target;
    public HelloServiceProxy(HelloService target) {
        this.target = target;
    }

    @Override
    public void sayHello() {
        System.out.println("log:sayHello马上要执行了...");
        target.sayHello();
    }
}
