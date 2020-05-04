package com.ooad.observer;

public class TestTeam implements Observer{

    // 被观察者
    private Project project;

    public TestTeam(Project subject) {
        this.project = subject;
        this.project.add(this);
    }

    // 自己的实现，要根据被观察者的改动做出响应
    @Override
    public void update() {
        System.out.println("project delay. test can slow");
    }
}
