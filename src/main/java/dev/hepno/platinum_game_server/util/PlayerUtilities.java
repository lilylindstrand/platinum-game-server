package dev.hepno.platinum_game_server.util;

import dev.hepno.platinum_game_server.PlatinumGameServerApplication;
import dev.hepno.platinum_game_server.player.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class PlayerUtilities {

    private final PlatinumGameServerApplication main;
    public PlayerUtilities(PlatinumGameServerApplication main) {
        this.main = main;
    }

    public User getPlayerByPrincipal(OAuth2User principal) {
        return main.getUserService().getUserRepository().findByDiscordId(principal.getAttribute("id"));
    }

}
