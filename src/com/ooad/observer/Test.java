package com.ooad.observer;

public class Test {
    public static void main(String[] args) {
        Project subject = new Project();
        Observer codingTeam = new CodingTeam(subject);
        Observer testTeam = new TestTeam(subject);

        subject.notifyObservers();
    }
}
