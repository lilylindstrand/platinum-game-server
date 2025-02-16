package dev.hepno.platinum_game_server.player;

import lombok.Data;

@Data
public class GamePlayer {

    // Permanent values only. Stuff like max health can be stored, but currenthealth cannot, anything that refreshes between logins must be in the OnlinePlayer class
    int coins = 0;
    int level = 0;
    int xp = 0;
    int maxHealth = 100;
    int maxMana = 100;

    public String toString() {
        return "GamePlayer{" +
                "coins=" + coins +
                ", level=" + level +
                ", xp=" + xp +
                ", maxHealth=" + maxHealth +
                ", maxMana=" + maxMana +
                "}";
    }

}
