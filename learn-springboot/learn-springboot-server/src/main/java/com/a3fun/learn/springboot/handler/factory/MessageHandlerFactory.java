package com.a3fun.learn.springboot.handler.factory;

import com.a3fun.learn.springboot.handler.MessageHandler;

/**
 * 消息处理工厂
 */
public interface MessageHandlerFactory {
    /**
     * 根据消息类型获取处理器
     * @param message
     * @return
     * @param <H>
     */
    <H extends MessageHandler<?, ?>> H getMessageHandler(int message);
}
