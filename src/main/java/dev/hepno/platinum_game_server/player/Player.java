package dev.hepno.platinum_game_server.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@Document("players")
public class Player {

    @Id
    private int id;
    private String discordId;
    private String username;
    private String emailAddress;
    private Date accountCreationDate;
    private GamePlayer gamePlayer;

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", discordId=" + discordId +
                ", username=" + username +
                ", email=" + emailAddress +
                ", accountCreationDate=" + accountCreationDate +
                ", " + gamePlayer.toString() +
                '}';
    }
}