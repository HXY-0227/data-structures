package com.ooad.proxy.staticproxy;

/**
 * 委托类/目标类
 *
 * @author HXY
 * @since 2020-5-9
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHello() {
        System.out.println("hello world");
    }
}
