package dev.hepno.platinum_game_server.controller;

import dev.hepno.platinum_game_server.PlatinumGameServerApplication;
import dev.hepno.platinum_game_server.player.Player;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@AllArgsConstructor
@RestController
public class WebController {

    public PlatinumGameServerApplication main;

    @GetMapping(path = "/players/{id}")
    public Player getPlayer(@PathVariable int id) {
        return main.getPlayerService().getPlayerRepository().findById(id);
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/test")
    public String test(@AuthenticationPrincipal OAuth2User principal) {
        return "Welcome, " + main.getPlayerService().getPlayerRepository().findByDiscordId(principal.getAttribute("id")).getUsername();
    }

}
