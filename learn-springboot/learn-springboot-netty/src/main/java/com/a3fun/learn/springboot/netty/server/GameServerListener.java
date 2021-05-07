package com.a3fun.learn.springboot.netty.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Netty 服务监听器
 * @author haixiangchen
 */
@WebListener
public class GameServerListener implements ServletContextListener {

    private Logger LOGGER = LoggerFactory.getLogger(GameServerListener.class);

    /**
     * 注入NettyServer
     *
     */
    @Resource
    private GameServer gameServer;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.info("ServletContext初始化...");

        Thread thread = new Thread(new NettyServerThread());
        // 启动netty服务
        thread.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    /**
     * Netty 服务启动线程
     */
    private class NettyServerThread implements Runnable {

        @Override
        public void run() {
            gameServer.run();
        }
    }

}