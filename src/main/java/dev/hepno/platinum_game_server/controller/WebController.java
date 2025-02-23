package dev.hepno.platinum_game_server.controller;

import dev.hepno.platinum_game_server.PlatinumGameServerApplication;
import dev.hepno.platinum_game_server.player.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@Controller
public class WebController {

    public PlatinumGameServerApplication main;

    @GetMapping(path = "/players/{id}")
    public String getPlayer(@PathVariable int id, Model model) {
        User user = main.getUserService().getUserRepository().findById(id);
        model.addAttribute("user", user);
        return "user-details";
    }


    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/welcome")
    public String welcome(@AuthenticationPrincipal OAuth2User principal, Model model, HttpServletRequest request) {
        String username = main.getPlayerUtilities().getPlayerByPrincipal(principal).getUsername();
        String pfp = "https://cdn.discordapp.com/avatars/" + principal.getAttribute("id") + "/" + principal.getAttribute("avatar");
        model.addAttribute("username", username);
        model.addAttribute("pfp", pfp);
        model.addAttribute("email", principal.getAttribute("email"));
        model.addAttribute("gamePlayer", main.getPlayerUtilities().getPlayerByPrincipal(principal).getGamePlayer()).toString();

        String sessionId = request.getSession().getId();
        model.addAttribute("sessionId", sessionId);

        return "redirect:http://localhost:5959/" + sessionId;
    }

}
