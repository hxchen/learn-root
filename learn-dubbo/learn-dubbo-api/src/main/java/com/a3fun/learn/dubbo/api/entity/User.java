package com.a3fun.learn.dubbo.api.entity;

import java.io.Serializable;

/**
 * @author haixiangchen
 */
public class User implements Serializable {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
