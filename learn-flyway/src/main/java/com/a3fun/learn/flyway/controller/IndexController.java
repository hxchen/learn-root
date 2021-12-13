package com.a3fun.learn.flyway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haixiangchen
 */
@RestController(value = "/")

public class IndexController {

    @RequestMapping(value = "/")
    public String index(){
        return "hello, flyway!";
    }
}
