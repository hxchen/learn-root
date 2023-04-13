package com.a3fun.learn.springboot.world;

import com.a3fun.learn.springboot.service.WorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorldWorker implements Runnable {
    private Logger LOGGER = LoggerFactory.getLogger(WorldWorker.class);
    private WorldService worldService;

    public WorldWorker(WorldService worldService){
        this.worldService = worldService;
    }
    @Override
    public void run() {
        LOGGER.info("World worker is running ...");
        worldService.getWorld().tick(System.currentTimeMillis());
    }
}
