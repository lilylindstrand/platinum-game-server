package dev.hepno.platinum_game_server.service;

import dev.hepno.platinum_game_server.player.GamePlayer;
import dev.hepno.platinum_game_server.player.Player;
import dev.hepno.platinum_game_server.player.PlayerRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class PlayerService {

    @Getter
    @Autowired
    public PlayerRepository playerRepository;

    public Player findOrCreatePlayer(DefaultOAuth2User principal) {
        Player player = playerRepository.findByDiscordId(principal.getAttribute("id"));
        if (player == null) {
            player = new Player();
            player.setDiscordId(principal.getAttribute("id"));
            player.setUsername(principal.getAttribute("username"));
            player.setEmailAddress("test@test.test");
            player.setAccountCreationDate(Date.from(Instant.now()));
            player.setGamePlayer(new GamePlayer());
            playerRepository.save(player);
        }
        return player;
    }
}
