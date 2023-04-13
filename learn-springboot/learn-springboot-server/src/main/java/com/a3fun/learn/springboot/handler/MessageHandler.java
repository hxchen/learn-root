package com.a3fun.learn.springboot.handler;

public interface MessageHandler <T, S>{
    void handle(T message, S session);

}
