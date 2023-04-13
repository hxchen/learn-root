package com.a3fun.learn.springboot.handler;

import com.a3fun.learn.springboot.model.Player;

public interface CsMessageHandler<T> extends MessageHandler<T, Player>{
    @Override
    void handle(T message, Player session);

}
