package dev.hepno.platinum_game_server.event;

import dev.hepno.platinum_api.packet.PlayerDisconnectPacket;
import dev.hepno.platinum_game_server.Core;
import dev.hepno.platinum_game_server.player.Player;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PlayerDisconnectEvent extends ApplicationEvent {

    private final PlayerDisconnectPacket playerDisconnectPacket;

    private final Player player;

    public PlayerDisconnectEvent(Object source, PlayerDisconnectPacket playerDisconnectPacket) {
        super(source);
        this.playerDisconnectPacket = playerDisconnectPacket;
        player = Core.getServer().getPlayerBySession(playerDisconnectPacket.getSessionId());
    }
}
