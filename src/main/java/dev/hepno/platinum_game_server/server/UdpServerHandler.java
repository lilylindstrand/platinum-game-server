package dev.hepno.platinum_game_server.server;

import dev.hepno.platinum_api.packet.*;
import dev.hepno.platinum_game_server.event.PlayerConnectEvent;
import dev.hepno.platinum_game_server.event.PlayerDisconnectEvent;
import dev.hepno.platinum_game_server.event.PlayerFreeCoinEvent;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void channelRead0(ChannelHandlerContext context, DatagramPacket datagramPacket) throws Exception {
        ByteBuf content = datagramPacket.content();
        PacketType packetType = PacketType.values()[content.readInt()];

        Packet packet = packetType.createPacket();
        packet.decode(content);

        if (packet instanceof PlayerFreeCoinPacket playerFreeCoinPacket) {
            eventPublisher.publishEvent(new PlayerFreeCoinEvent(this, playerFreeCoinPacket));
        }
        else if (packet instanceof PlayerConnectPacket playerConnectPacket) {
            eventPublisher.publishEvent(new PlayerConnectEvent(this, playerConnectPacket));
        }
        else if (packet instanceof PlayerDisconnectPacket playerDisconnectPacket) {
            eventPublisher.publishEvent(new PlayerDisconnectEvent(this, playerDisconnectPacket));
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext context) {
        context.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause) {
        cause.printStackTrace();
    }
}
