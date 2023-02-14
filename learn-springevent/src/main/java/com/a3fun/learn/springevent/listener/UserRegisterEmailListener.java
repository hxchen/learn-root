package com.a3fun.learn.springevent.listener;

import com.a3fun.learn.springevent.vo.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 通过接口实现的监听器
 * @author haixiangchen
 */
@Component
public class UserRegisterEmailListener implements ApplicationListener<User> {


    @Override
    public void onApplicationEvent(User user) {
        System.out.println("用户注册,发送邮件：" + user.toString());
    }
}
