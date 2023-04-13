package com.a3fun.learn.springboot.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

/**
 * 服务器端监听处理
 * 服务器端继承ChannelInboundHandlerAdapter
 * SimpleChannelInboundHandler在接收到数据后会自动release掉数据占用的ByteBuffer资源(自动调用ByteBuffer.release())
 *
 * @author haixiangchen
 */
@Component
@Sharable
public class GameServerHandler extends ChannelInboundHandlerAdapter {
    Set<Channel> channelSet = new HashSet<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(GameServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        LOGGER.info("服务器端收到的数据："+in.toString(CharsetUtil.UTF_8));
        channelSet.add(ctx.channel());
        System.out.format("连接数量  = %s \n" , channelSet.size());
        ctx.channel().writeAndFlush("您的来信：[" + in.toString(CharsetUtil.UTF_8) + "] 已经收到");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

}
