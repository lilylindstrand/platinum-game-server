package dev.hepno.platinum_game_server;

import dev.hepno.platinum_game_server.player.Player;
import dev.hepno.platinum_game_server.player.PlayerRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@RestController
public class PlatinumGameServerApplication implements CommandLineRunner {

	@Getter
	@Autowired
	private PlayerRepository playerRepository;

	public static void main(String[] args) {
		SpringApplication.run(PlatinumGameServerApplication.class, args);
	}

	@Override
	public void run(String[] args) throws Exception {
	}
}