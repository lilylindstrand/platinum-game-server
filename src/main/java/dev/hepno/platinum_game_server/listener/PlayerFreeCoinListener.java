package dev.hepno.platinum_game_server.listener;

import dev.hepno.platinum_game_server.event.PlayerFreeCoinEvent;
import dev.hepno.platinum_game_server.player.User;
import dev.hepno.platinum_game_server.service.UserService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PlayerFreeCoinListener {

    private final UserService userService;

    public PlayerFreeCoinListener(UserService userService) {
        this.userService = userService;
    }

    @EventListener
    public void handlePlayerFreeCoinEvent(PlayerFreeCoinEvent event) {
        event.getPlayer().getUser().getGamePlayer().setCoins(event.getPlayer().getUser().getGamePlayer().getCoins() + 1);
        userService.updateUser(event.getPlayer());
        System.out.println("meow");
    }

}
