package com.a3fun.learn.java.eventlistener;

/**
 * @author haixiangchen
 */
public class TestEventListener {

    public static void main(String[] args) {
        Person person = new Person();
        //注册监听器()
        person.registerListener(new PersonListener() {
            @Override
            public void doEat(PersonEvent event) {
                Person person1 = event.getResource();
                System.out.println(person1 + "正在吃饭呢！");
            }

            @Override
            public void doSleep(PersonEvent event) {
                Person person1 = event.getResource();
                System.out.println(person1 + "正在睡觉呢！");
            }
        });
        person.eat();
        person.sleep();
    }

}
