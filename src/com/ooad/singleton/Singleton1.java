package com.ooad.singleton;

/**
 * 饿汉模式
 * 线程不安全，类加载时候就初始化
 *
 * @author HXY
 * @since 2020-5-3
 */
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1() {

    }
    public static Singleton1 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Singleton1.getInstance());
        }).start();

        new Thread(() -> {
            System.out.println(Singleton1.getInstance());
        }).start();

    }
}
