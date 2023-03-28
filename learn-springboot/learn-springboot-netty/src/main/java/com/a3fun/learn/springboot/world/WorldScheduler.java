package com.a3fun.learn.springboot.world;

import com.a3fun.learn.springboot.exec.MainWorker;
import com.a3fun.learn.springboot.exec.SingleThreadWorker;
import com.a3fun.learn.springboot.service.WorldService;
import com.a3fun.learn.springboot.util.ApplicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorldScheduler extends SingleThreadWorker {
    private Logger LOGGER = LoggerFactory.getLogger(WorldScheduler.class);
    private MainWorker mainWorker = ApplicationUtil.getBean(MainWorker.class);
    private WorldWorker worldWorker = new WorldWorker(ApplicationUtil.getBean(WorldService.class));
    @Override
    protected void execute() throws InterruptedException {
        LOGGER.info(Thread.currentThread().getName() + ",   WorldScheduler execute");
        mainWorker.putWorldWorker(worldWorker);
    }
}
