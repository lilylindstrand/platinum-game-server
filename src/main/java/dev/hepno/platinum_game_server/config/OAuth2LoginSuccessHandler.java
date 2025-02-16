package dev.hepno.platinum_game_server.config;

import dev.hepno.platinum_game_server.PlatinumGameServerApplication;
import dev.hepno.platinum_game_server.player.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

@Component
public class OAuth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    public PlatinumGameServerApplication main;

    public OAuth2LoginSuccessHandler(PlatinumGameServerApplication main) {
        this.main = main;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        DefaultOAuth2User principal = (DefaultOAuth2User) authentication.getPrincipal();
        main.getPlayerService().findOrCreatePlayer(principal);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
