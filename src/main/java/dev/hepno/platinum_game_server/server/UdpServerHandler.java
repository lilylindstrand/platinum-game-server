package dev.hepno.platinum_game_server.server;

import dev.hepno.platinum_api.packet.Packet;
import dev.hepno.platinum_api.packet.PacketType;
import dev.hepno.platinum_api.packet.PlayerFreeCoinPacket;
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

        if (packet instanceof PlayerFreeCoinPacket) {
            PlayerFreeCoinPacket playerFreeCoinPacket = (PlayerFreeCoinPacket) packet;
            System.out.println(playerFreeCoinPacket.getSessionId());
            eventPublisher.publishEvent(new PlayerFreeCoinEvent(this, playerFreeCoinPacket));
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
