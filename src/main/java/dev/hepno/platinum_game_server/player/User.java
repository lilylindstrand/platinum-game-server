package dev.hepno.platinum_game_server.player;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@RequiredArgsConstructor
@Document("users")
public class User {

    @Id
    private ObjectId id;
    private String discordId;
    private String username;
    private String emailAddress;
    private Date accountCreationDate;
    private GamePlayer gamePlayer;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", discordId=" + discordId +
                ", username=" + username +
                ", email=" + emailAddress +
                ", accountCreationDate=" + accountCreationDate +
                ", " + gamePlayer.toString() +
                '}';
    }
}