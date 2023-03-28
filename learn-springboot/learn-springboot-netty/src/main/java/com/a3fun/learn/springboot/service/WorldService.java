package com.a3fun.learn.springboot.service;

import com.a3fun.learn.springboot.world.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorldService {
    private World world;

    @Autowired
    ServiceContainer serviceContainer;

    public World getWorld() {
        return world;
    }

    public void init(){
        this.world = new World();
        this.world.init(serviceContainer);
    }
}
