package com.a3fun.learn.springboot.handler;

import com.a3fun.learn.springboot.model.Player;
import com.a3fun.learn.springboot.model.Role;

public abstract class CsAbstractMessageHandler<T> implements CsMessageHandler<T>{

    @Override
    public void handle(T message, Player session) {
        handle(new Role(), message);
    }

    protected abstract void handle(Role role, T message);
}
