package dev.hepno.platinum_game_server.controller;

import dev.hepno.platinum_game_server.PlatinumGameServerApplication;
import dev.hepno.platinum_game_server.player.Player;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@AllArgsConstructor
@Controller
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

    @GetMapping("/welcome")
    public String welcome(@AuthenticationPrincipal OAuth2User principal, Model model) {
        String username = main.getPlayerUtilities().getPlayerByPrincipal(principal).getUsername();
        String pfp = "https://cdn.discordapp.com/avatars/" + principal.getAttribute("id") + "/" + principal.getAttribute("avatar");
        model.addAttribute("username", username);
        model.addAttribute("pfp", pfp);
        model.addAttribute("gamePlayer", main.getPlayerUtilities().getPlayerByPrincipal(principal).getGamePlayer()).toString();
        return "welcome";
    }

}
