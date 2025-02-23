package dev.hepno.platinum_game_server.event;

import dev.hepno.platinum_api.packet.PlayerConnectPacket;
import dev.hepno.platinum_game_server.Core;
import dev.hepno.platinum_game_server.player.Player;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PlayerConnectEvent extends ApplicationEvent {
    private final PlayerConnectPacket playerConnectPacket;

    private final Player player;

    public PlayerConnectEvent(Object source, PlayerConnectPacket playerConnectPacket) {
        super(source);
        this.playerConnectPacket = playerConnectPacket;
        player = Core.getServer().getPlayerBySession(playerConnectPacket.getSessionId());
    }
}
