package com.a3fun.learn.springevent.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.a3fun.learn.springevent.vo.User;

/**
 * 通过注解实现的监听器
 * @author haixiangchen
 */
@Component
public class UserRegisterSMSListener {

    @EventListener
    public void handleUserEvent(User user){
        System.out.println("用户注册,发送短信：" + user.toString());
    }

}
