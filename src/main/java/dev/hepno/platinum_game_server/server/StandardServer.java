package dev.hepno.platinum_game_server.server;


import dev.hepno.platinum_game_server.player.OnlinePlayer;
import dev.hepno.platinum_game_server.player.Player;
import dev.hepno.platinum_game_server.player.StandardPlayer;
import dev.hepno.platinum_game_server.player.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StandardServer implements Server {

    private final String serverName = "PlatinumGameServer";
    private final String serverVersion = "1.0.0";
    private final String ip = "127.0.0.1";
    private final int mainPort = 8080;
    private final int udpPort = 7777;
    private List<Player> onlinePlayers;

    public StandardServer() {
        onlinePlayers = new ArrayList<>();
    }

    @Override
    public String getServerName() {
        return "";
    }

    @Override
    public String getServerVersion() {
        return "";
    }

    @Override
    public String getIp() {
        return "";
    }

    @Override
    public int getMainPort() {
        return 0;
    }

    @Override
    public int getUDPPort() {
        return 0;
    }

    @Override
    public Collection<? extends Player> getOnlinePlayers() {
        return onlinePlayers;
    }

    @Override
    public Player getPlayerBySession(String sessionId) {
        for (Player player : getOnlinePlayers()) {
            if (player.getSessionId().equals(sessionId)) {
                return player;
            }
        }
        return null;
    }

    @Override
    public Player getPlayer(String username) {
        return null;
    }

    @Override
    public Player getPlayer(int id) {
        return null;
    }

    @Override
    public void connectPlayer(String sessionId, User user) {
        if (getPlayerBySession(sessionId) != null) {
            disconnectPlayer(user);
            return;
        }
        Player player = new StandardPlayer();
        player.setSessionId(sessionId);
        player.setUser(user);
        onlinePlayers.add(player);
    }

    @Override
    public void disconnectPlayer(User user) {
    }

    @Override
    public void disconnectPlayer(Player player) {
        onlinePlayers.remove(player);
    }
}
