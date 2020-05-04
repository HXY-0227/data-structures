package com.ooad.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 被观察者的一个抽象实现 提供基本的实现
 *
 * @author HXY
 * @since 2020-5-2
 */
public abstract class AbstractSubject implements Subject{
    private List<Observer> observerList = new ArrayList<>();
    public void add(Observer observer) {
        observerList.add(observer);
    }

    public void del(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObservers() {
        Iterator<Observer> it = observerList.iterator();
        while(it.hasNext()){
            Observer next = it.next();
            next.update();
        }
    }
}
