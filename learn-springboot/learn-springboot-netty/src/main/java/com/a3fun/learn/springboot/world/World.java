package com.a3fun.learn.springboot.world;

import com.a3fun.learn.springboot.netty.server.GameServerListener;
import com.a3fun.learn.springboot.service.ServiceContainer;
import com.a3fun.learn.springboot.service.VIPService;
import com.a3fun.learn.springboot.tick.AbstractTicker;
import com.a3fun.learn.springboot.util.ApplicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class World {
    private Logger LOGGER = LoggerFactory.getLogger(GameServerListener.class);

    List<AbstractTicker<?>> tickers;

    ServiceContainer serviceContainer;

    public void init(ServiceContainer serviceContainer){
        this.serviceContainer = serviceContainer;
        tickers = new ArrayList<>();
        Map<String, AbstractTicker> beansOfType = ApplicationUtil.getBeanOfType(AbstractTicker.class);
        LOGGER.info(Thread.currentThread().getName() + "Ticker 初始化大小：" + beansOfType.size());
        for (AbstractTicker ticker : beansOfType.values()) {
            tickers.add(ticker);
        }
    }



    public void tick(long now){

        for (AbstractTicker<?> ticker : tickers) {
            LOGGER.info(Thread.currentThread().getName() + ticker + "执行tick");
            ticker.tick(now);
        }

        serviceContainer.getVipService().tick(System.currentTimeMillis());
    }

}
