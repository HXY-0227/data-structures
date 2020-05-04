package com.ooad.observer;

/**
 * 被观察者接口, 定义注册、通知、删除观察者的方法
 *
 * @author HXY
 * @since 2020-5-2
 */
public interface Subject {
    /*增加观察者*/
    void add(Observer observer);

    /*删除观察者*/
    void del(Observer observer);

    /*通知所有的观察者*/
    void notifyObservers();

    /**自身的操作*/
    void operation();
}
