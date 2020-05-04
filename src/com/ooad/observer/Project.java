package com.ooad.observer;

/**
 * 我们自己的一个被观察者实现
 * 这里我们定义一个项目类
 *
 * @author HXY
 * @since 2020-5-2
 */
public class Project extends AbstractSubject{

    @Override
    public void operation() {
        System.out.println("project delay...");
        notifyObservers();
    }
}
