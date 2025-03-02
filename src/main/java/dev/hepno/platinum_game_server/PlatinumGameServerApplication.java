package dev.hepno.platinum_game_server;

import dev.hepno.platinum_game_server.config.OAuth2LoginSuccessHandler;
import dev.hepno.platinum_game_server.server.Server;
import dev.hepno.platinum_game_server.server.StandardServer;
import dev.hepno.platinum_game_server.server.UdpServer;
import dev.hepno.platinum_game_server.service.UserService;
import dev.hepno.platinum_game_server.util.PlayerUtilities;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@Getter
@SpringBootApplication
@RestController
public class PlatinumGameServerApplication implements CommandLineRunner {

	private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
	private PlayerUtilities playerUtilities;
	private StandardServer server;

	@Autowired
	private UdpServer udpServer;
	@Autowired
	private UserService userService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PlatinumGameServerApplication.class, args);
	}

	@Override
	public void run(String[] args) throws Exception {
		server = new StandardServer();
		Core.setServer(server);

		oAuth2LoginSuccessHandler = new OAuth2LoginSuccessHandler(this);

		playerUtilities = new PlayerUtilities(this);
		udpServer.run();
	}
}