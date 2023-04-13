package com.a3fun.learn.springboot.exec;

import com.a3fun.learn.springboot.world.WorldWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MainWorker extends SingleThreadTaskWorker<Object>{
    private Logger LOGGER = LoggerFactory.getLogger(MainWorker.class);

    public void putWorldWorker(WorldWorker worldWorker){
        addTask(worldWorker);
    }
    @Override
    protected void execute(Object task) {
        LOGGER.info(Thread.currentThread().getName() + "    Main worker execute");
        if (task instanceof WorldWorker){
            WorldWorker worker = (WorldWorker) task;
            worker.run();
        }else{
            LOGGER.info("Task:{task}" + task);
        }
    }

}
