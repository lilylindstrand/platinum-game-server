package dev.hepno.platinum_game_server.player;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findById(int id);
    public User findByDiscordId(String discordId);

}
