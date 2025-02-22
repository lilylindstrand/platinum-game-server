package dev.hepno.platinum_game_server.event;

import dev.hepno.platinum_api.packet.PlayerFreeCoinPacket;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PlayerFreeCoinEvent extends ApplicationEvent {

    private final PlayerFreeCoinPacket playerFreeCoinPacket;

    //TODO: Make events contain far more info such as Player objects, OnlinePlayer objects, etc. will be easier once sessions & auth are properly implemented
    private final int discordId;
    private final float x;
    private final float y;

    public PlayerFreeCoinEvent(Object source, PlayerFreeCoinPacket playerFreeCoinPacket) {
        super(source);
        this.playerFreeCoinPacket = playerFreeCoinPacket;
        discordId = playerFreeCoinPacket.getDiscordId();
        x = playerFreeCoinPacket.getX();
        y = playerFreeCoinPacket.getY();
    }


}
