package com.a3fun.learn.springevent.listener;

import com.a3fun.learn.springevent.vo.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 通过接口实现的站内消息
 * @author haixiangchen
 */
@Component
public class UserRegisterMessageListener implements ApplicationListener<User> {

    @Override
    public void onApplicationEvent(User user) {

        System.out.println("用户注册,发送站内消息：" + user.toString());
    }
}
