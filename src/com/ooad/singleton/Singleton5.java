package com.ooad.singleton;

/**
 * 静态内部类注册模式
 * 线程安全，类加载时候就初始化
 *
 * @author HXY
 * @since 2020-5-3
 */
public class Singleton5 {

    private Singleton5() {

    }

    private static class SingletonInstance {
        private static  final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton5.getInstance());
            }
        }).start();

        new Thread(() -> {
            System.out.println(Singleton5.getInstance());
        }).start();

        new Thread() {
            @Override
            public void run() {
                System.out.println(Singleton5.getInstance());
            }
        }.start();
    }
}
