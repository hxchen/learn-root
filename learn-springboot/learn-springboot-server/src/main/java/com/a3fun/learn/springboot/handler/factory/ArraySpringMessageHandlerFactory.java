package com.a3fun.learn.springboot.handler.factory;

import com.a3fun.learn.springboot.handler.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Slf4j
public class ArraySpringMessageHandlerFactory extends AbstractSpringMessageHandlerFactory {
    private int size = 10000;
    private MessageHandler<?, ?>[] handlers = null;

    public ArraySpringMessageHandlerFactory(){
        log.info("ArraySpringMessageHandlerFactory 构造函数");
    }

    @Override
    public void init() {
        handlers = new MessageHandler[size];
        super.init();
    }


    @Override
    protected void registerHandler(int messagedId, MessageHandler<?, ?> handler) {
        handlers[messagedId] = handler;
    }

    @Override
    public <H extends MessageHandler<?, ?>> H getMessageHandler(int message) {
        log.info("获取消息处理器");
        H handler = (H)handlers[message];
        return handler;
    }

    private void destroy() {

    }
}
