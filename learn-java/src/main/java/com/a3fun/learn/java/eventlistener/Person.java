package com.a3fun.learn.java.eventlistener;

/**
 * 事件源
 *
 * @author haixiangchen
 */
public class Person {
    private PersonListener personListener;

    public void eat() {
        personListener.doEat(new PersonEvent(this));
    }

    public void sleep() {
        personListener.doSleep(new PersonEvent(this));
    }

    public void registerListener(PersonListener personListener) {
        this.personListener = personListener;
    }
}
