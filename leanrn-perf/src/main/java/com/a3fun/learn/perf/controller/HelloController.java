package com.a3fun.learn.perf.controller;

import org.perf4j.StopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haixiangchen
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/pref")
    public String pref() {
        StopWatch stopWatch = new Slf4JStopWatch();
        stopWatch.start("PERF");
        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }finally {
            stopWatch.stop();
        }
        return "test";
    }
}
