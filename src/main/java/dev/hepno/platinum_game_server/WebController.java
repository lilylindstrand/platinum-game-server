package dev.hepno.platinum_game_server;

import com.sun.tools.javac.Main;
import dev.hepno.platinum_game_server.player.Player;
import dev.hepno.platinum_game_server.player.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class WebController {

    public PlatinumGameServerApplication main;

    @GetMapping(path = "/players/{id}")
    public Player getPlayer(@PathVariable int id) {
        return main.getPlayerRepository().findById(id);
    }

}
