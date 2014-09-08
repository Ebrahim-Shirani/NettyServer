package com.example.ebicompany.nettyserver;

import android.view.View;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.ssl.SslContext;

/**
 * Created by ebicompany on 9/3/14.
 */
public class HsWebSocketServerInitializer extends ChannelInitializer<SocketChannel> {
    private final SslContext sslCtx;
    private View messageAria;

    public HsWebSocketServerInitializer(SslContext sslCtx, View txtAria) {
        this.sslCtx = sslCtx;
        this.messageAria = txtAria;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        if (sslCtx != null) {
            pipeline.addLast(sslCtx.newHandler(ch.alloc()));
        }
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(65536));
        pipeline.addLast(new HsWebSocketServerHandler(this.messageAria));
    }
}
