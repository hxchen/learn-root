package com.a3fun.learn.springboot.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.nio.ByteBuffer;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(GameServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        byte[] by = new byte [in.readableBytes()];
        in.readBytes(by);
        ByteBuffer buf = ByteBuffer.wrap(by);
        LOGGER.info(buf.toString());
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
