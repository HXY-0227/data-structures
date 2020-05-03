package com.ooad.singleton;

/**
 * 懒汉模式线程安全实现
 *
 * @author HXY
 * @since 2020-5-3
 */
public class Singleton3 {
    private static Singleton3 instance = null;
    private Singleton3() {

    }

    // 性能问题，当一个线程进入该方法之后，其它试图进入该方法的线程都必须等待，但是可能instance已经实例化了
    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
