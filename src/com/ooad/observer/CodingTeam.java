package com.ooad.observer;

/**
 * 开发组，观察project，如果项目有变动，就要做一些改动
 *
 * @author HXY
 * @since 2020-5-4
 */
public class CodingTeam implements Observer{

    // 被观察者
    private Project project;

    public CodingTeam(Project subject) {
        this.project = subject;
        this.project.add(this);
    }

    // 自己的实现，要根据被观察者的改动做出响应
    @Override
    public void update() {
        System.out.println("project delay. coding can slow");
    }
}
