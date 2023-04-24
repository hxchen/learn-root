package com.a3fun.learn.springboot.handler.factory;

import com.a3fun.learn.springboot.handler.MessageHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 使用Spring 容器来对Handler进行管理
 * @author haixiangchen
 */
public abstract class AbstractSpringMessageHandlerFactory extends AbstractMessageHandlerFactory implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    protected MessageHandler<?, ?> getHandlerInstance(int messageId, Class<? extends MessageHandler<?, ?>> clazz) {
        return applicationContext.getBean(clazz);
    }
}
