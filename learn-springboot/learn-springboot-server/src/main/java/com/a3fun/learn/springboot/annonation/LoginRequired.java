package com.a3fun.learn.springboot.annonation;

import java.lang.annotation.*;

/**
 * 需要登录的注解，有此注解的地方会检查是否登录
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginRequired {

}
