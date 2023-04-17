package com.a3fun.learn.springboot.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 服务端初始化
 * @author haixiangchen
 */
@Component
public class GameServerInitializer extends ChannelInitializer<SocketChannel> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameServerInitializer.class);

    @Resource
    GameServerHandler gameServerHandler;
    @Resource
    LoginAuthHandler loginAuthHandler;

    /**
     * 初始化channel
     */
    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new IdleStateHandler(5, 0, 0));
        pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
        pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
        pipeline.addLast("loginHandler", loginAuthHandler);
        pipeline.addLast("handler", gameServerHandler);
    }

}
