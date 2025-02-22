package dev.hepno.platinum_game_server.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import lombok.Data;

@Data
public class UdpServer {

    private static final int PORT = 7777;
    private EventLoopGroup eventLoopGroup;
    private Bootstrap bootstrap;
    private UdpServerHandler handler;

    public void run() throws Exception {
        eventLoopGroup = new NioEventLoopGroup();
        handler = new UdpServerHandler();
        try {
            bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(handler);
            bootstrap.bind(PORT).sync().channel().closeFuture().await();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

}
