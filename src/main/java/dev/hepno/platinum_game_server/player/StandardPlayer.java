package dev.hepno.platinum_game_server.player;

public class StandardPlayer implements Player {

    private User user;
    private String sessionId;

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Player getPlayer() {
        return this;
    }

    @Override
    public String getName() {
        return user.getUsername();
    }

    @Override
    public String getSessionId() {
        return sessionId;
    }

    @Override
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
