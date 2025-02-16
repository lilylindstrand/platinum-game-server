package dev.hepno.platinum_game_server.player;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PlayerRepository extends MongoRepository<Player, String> {

    public Player findById(int id);
    public Player findByDiscordId(String discordId);

}
