package com.ooad.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {

        IStudentService target = new StudentServiceImpl();

        Class<? extends IStudentService> c = target.getClass();
        ClassLoader classLoader = c.getClassLoader();
        Class<?>[] interfaces = c.getInterfaces();
        InvocationHandler h = new MyHandler(target);

        // classLoader类加载器   定义了代理类的ClassLoder
        // interfaces目标对象实现的接口，是一个数组
        // Handler对目标对象中方法的操作（执行之前，或着执行之后）
        IStudentService service = (IStudentService) Proxy.newProxyInstance(classLoader, interfaces, h);
        service.delete(1);
        // proxy.delete(1L);
        service.save(new Student());
        service.find(1L);
        service.update(30);

        // System.out.println(proxy.toString());
        // System.out.println(proxy.getClass());

    }
}
