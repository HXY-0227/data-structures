package com.ooad.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//InvocationHandler接口的实现类 ,位于代理类与委托类之间的中介类
//JDK动态代理中必须用到的接口实现

/* public interface InvocationHandler{
 *	  Object invoke(Object proxy,Method method,Object[] args);
 * }
 * 实现了这个接口的中介类用作“调用处理器”，当我们调用代理类对象的方法时，
 * 这个“调用”会转送到invoke方法中，代理类对象作为proxy参数传入
 * 参数method标识了我们具体调用的是代理类的那个方法
 * args为这个方法的参数
 * 这样一来，我们对代理类中的所有方法的调用都会变为对invoke的调用
 * 这样我们可以在invoke方法中统一添加处理逻辑
 * 也可以根据method参数对不同的代理类方法做不同的代理
 *
 */
public class MyHandler implements InvocationHandler {
    // target为委托类对象
    private Object target;
    private StudentLogger logger = new StudentLogger();

    public MyHandler(Object target, StudentLogger logger) {
        this.target = target;
        this.logger = logger;
    }

    public MyHandler(Object target) {
        this.target = target;
    }

    // 参数1 proxy  将来给目标对象所动态产生的代理对象
    // 参数2 method 将来你所调用的目标对象中的方法的镜像
    // 参数3 args 将来你所调用方法的时候所传的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String msg = method.getName() + "方法被调用了..." + args;
        logger.log(msg);
        Object o = method.invoke(target, args);
        System.out.println("come over");
        return o;
    }
}
