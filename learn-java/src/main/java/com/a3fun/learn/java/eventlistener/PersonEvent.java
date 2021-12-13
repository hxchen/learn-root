package com.a3fun.learn.java.eventlistener;

/**
 * 事件对象
 *
 * @author haixiangchen
 */
public class PersonEvent {
    /**
     * 可以获取事件源
     */
    private Person person;

    public PersonEvent() {
    }

    public PersonEvent(Person person) {
        this.person = person;
    }

    public Person getResource() {
        return person;
    }

}
