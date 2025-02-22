package dev.hepno.platinum_game_server.server;

import dev.hepno.platinum_api.packet.Packet;
import dev.hepno.platinum_api.packet.PacketType;
import dev.hepno.platinum_api.packet.PlayerFreeCoinPacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import java.util.Random;

public class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    public void channelRead0(ChannelHandlerContext context, DatagramPacket datagramPacket) throws Exception {
        ByteBuf content = datagramPacket.content();
        PacketType packetType = PacketType.values()[content.readInt()];

        Packet packet = packetType.createPacket();
        packet.decode(content);

        if (packet instanceof PlayerFreeCoinPacket) {
            PlayerFreeCoinPacket playerFreeCoinPacket = (PlayerFreeCoinPacket) packet;
            System.out.println("Recieved PlayerFreeCoinPacket: " + playerFreeCoinPacket);
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
