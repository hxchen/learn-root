package com.a3fun.learn.springevent.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @author haixiangchen
 */
@Setter
@Getter
@ToString
public class User extends ApplicationEvent {
    private Long id;
    private String name;
    private Integer age;

    public User(Object source) {
        super(source);
    }
}
