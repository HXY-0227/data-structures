package com.ooad.singleton;

/**
 * 双重锁模式
 *
 * @author HXY
 * @since 2020-5-3
 */
public class Singleton4 {
    private volatile static Singleton4 instance = null;
    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        // 加锁的粒度小了
        if (instance == null) {
            synchronized (Singleton4.class) {
                // 这里判断空，是防止两个线程到上一步，如果没这个条件，那么线程1进来初始化对象，释放锁，
                // 然后线程2进来如果不判断空，就又创建一次
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
