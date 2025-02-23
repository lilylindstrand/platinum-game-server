package dev.hepno.platinum_game_server.service;

import dev.hepno.platinum_game_server.player.GamePlayer;
import dev.hepno.platinum_game_server.player.User;
import dev.hepno.platinum_game_server.player.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class UserService {

    @Getter
    @Autowired
    public UserRepository userRepository;

    public User findOrCreateUser(DefaultOAuth2User principal) {
        User user = userRepository.findByDiscordId(principal.getAttribute("id"));
        if (user == null) {
            user = new User();
            user.setDiscordId(principal.getAttribute("id"));
            user.setUsername(principal.getAttribute("username"));
            user.setEmailAddress(principal.getAttribute("email"));
            user.setAccountCreationDate(Date.from(Instant.now()));
            user.setGamePlayer(new GamePlayer());
            userRepository.save(user);
        }
        return user;
    }
}
