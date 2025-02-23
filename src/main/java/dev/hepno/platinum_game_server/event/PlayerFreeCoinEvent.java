package dev.hepno.platinum_game_server.event;

import dev.hepno.platinum_api.packet.PlayerFreeCoinPacket;
import dev.hepno.platinum_game_server.Core;
import dev.hepno.platinum_game_server.player.OnlinePlayer;
import dev.hepno.platinum_game_server.player.Player;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PlayerFreeCoinEvent extends ApplicationEvent {

    private final PlayerFreeCoinPacket playerFreeCoinPacket;

    private final Player player;
    private final float x;
    private final float y;

    public PlayerFreeCoinEvent(Object source, PlayerFreeCoinPacket playerFreeCoinPacket) {
        super(source);
        this.playerFreeCoinPacket = playerFreeCoinPacket;
        player = Core.getServer().getPlayerBySession(playerFreeCoinPacket.getSessionId());
        x = playerFreeCoinPacket.getX();
        y = playerFreeCoinPacket.getY();
    }


}
