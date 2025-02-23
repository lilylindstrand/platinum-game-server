package dev.hepno.platinum_game_server.player;

public interface OfflinePlayer {
    public User getUser();
    public void setUser(User user);
    public Player getPlayer();
    public String getName();
}
