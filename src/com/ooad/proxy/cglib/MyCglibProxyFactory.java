package com.ooad.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 产生代理对象的工厂类
 * 针对类来实现代理,对指定目标产生一个子类 通过方法拦截技术拦截所有父类方法的调用
 *
 * @author HXY
 * @since 2020-5-19
 */
public class MyCglibProxyFactory implements MethodInterceptor {
    public Object getInstance(Class<?> c) {
        // 通过Enhancer 创建代理对象
        Enhancer enhancer = new Enhancer();
        // c就是目标对象
        enhancer.setSuperclass(c);
        // 设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(this);
        // 创建动态代理类对象并返回
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        // 代理类要实现的操作
        // 这句代码最终会执行到我们目标对象中的方法
        // o代表的是目标对象执行后返回类型
        System.out.println(method.getName() + " begin...");
        Object o = proxy.invokeSuper(obj, args);
        System.out.println(method.getName() + " end...");

        return o;
    }
}
