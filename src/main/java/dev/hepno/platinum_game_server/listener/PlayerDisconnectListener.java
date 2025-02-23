package dev.hepno.platinum_game_server.listener;

import dev.hepno.platinum_game_server.Core;
import dev.hepno.platinum_game_server.event.PlayerDisconnectEvent;
import dev.hepno.platinum_game_server.event.PlayerFreeCoinEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PlayerDisconnectListener {

    @EventListener
    public void handlePlayerDisconnect(PlayerDisconnectEvent event) {
        Core.disconnectPlayer(event.getPlayer().getUser());
    }

}
