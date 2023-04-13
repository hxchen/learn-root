package com.a3fun.learn.springboot.service;

import com.a3fun.learn.springboot.tick.ITicker;
import org.springframework.stereotype.Service;

@Service
public class MissionService implements ITicker {

    @Override
    public void tick(long interval) {
        System.out.println("Mission Service");
    }
}
