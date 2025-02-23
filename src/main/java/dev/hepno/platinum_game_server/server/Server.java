package dev.hepno.platinum_game_server.server;


import dev.hepno.platinum_game_server.player.OnlinePlayer;
import dev.hepno.platinum_game_server.player.Player;
import dev.hepno.platinum_game_server.player.User;

import java.util.Collection;

public interface Server {

    /**
     * Gets the name of the server
     * @return the name of the server
     */
    public String getServerName();

    /**
     * Gets the current version of the server
     * @return the current version
     */
    public String getServerVersion();

    /**
     * Gets the IP address the server is running on
     * @return the ip address as a String
     */
    public String getIp();

    /**
     * Gets the primary port of the server, used for connection, authentication, etc
     * @return the port
     */
    public int getMainPort();

    /**
     * Gets the UDP port of the server, used for packets
     * @return the port
     */
    public int getUDPPort();

    /**
     * Returns a Collection of all currently logged in players.
     * @return a view of currently online players.
     */
    public Collection<? extends Player> getOnlinePlayers();

    /**
     * Gets the {@link Player} from a sessionId
     * @param sessionId the sessionId of the player you want to retrieve
     * @return the player if they exist & are online, null otherwise
     */
    public Player getPlayerBySession(String sessionId);

    /**
     * Gets the {@link Player} whose exact name matches the parameter
     * @param username the username to look up
     * @return a player if one was found, null otherwise
     */
    public Player getPlayer(String username);

    /**
     * Gets the {@link Player} whose exact id matches the paramater
     * @param id the mongodb id to look up
     * @return a player if one was found, null otherwise
     */
    public Player getPlayer(int id);

    /**
     * Connects a player to the server and adds them to the online player list
     * @param sessionId the sessionId to use for the new player
     * @param user the {@link User} object for the player to use
     */
    public void connectPlayer(String sessionId, User user);

    /**
     * Disconnects a player from the server and removes them from the online player list
     * @param user the {@link User} object of the player to remove
     */
    public void disconnectPlayer(User user);

    /**
     * Disconnects a player from the server and removes them from the online player list
     * @param player the {@link Player} object of the player to remove
     */
    public void disconnectPlayer(Player player);

}
