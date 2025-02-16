package dev.hepno.platinum_game_server.controller;

import dev.hepno.platinum_game_server.PlatinumGameServerApplication;
import dev.hepno.platinum_game_server.player.Player;
import lombok.AllArgsConstructor;
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
        return main.getPlayerRepository().findById(id);
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/test")
    public String test() {
        return "logged in";
    }

}
