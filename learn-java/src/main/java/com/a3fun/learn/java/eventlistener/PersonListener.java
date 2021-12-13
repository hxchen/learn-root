package com.a3fun.learn.java.eventlistener;

/**
 * 事件监听器
 *
 * @author haixiangchen
 */
public interface PersonListener {
    /**
     * 吃饭
     * @param event
     */
    void doEat(PersonEvent event);

    /**
     * 睡觉
     *
     * @param event
     */
    void doSleep(PersonEvent event);
}
