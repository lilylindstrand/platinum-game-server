package dev.hepno.platinum_game_server;

import dev.hepno.platinum_game_server.player.Player;
import dev.hepno.platinum_game_server.player.User;
import dev.hepno.platinum_game_server.server.Server;

public class Core {

    /**
     * Static class cannot be initialized.
     */
    private Core() {}
    private static Server server;

    /**
     * Attempts to set the {@link Server} singleton
     * @return Server instance being ran
     */
    public static Server getServer() {
        return server;
    }

    /**
     * Attempts to set the {@link Server} singleton.
     * This cannot be done if the server is already set.
     * @param server
     */
    public static void setServer(Server server) {
        if (Core.server != null) {
            throw new UnsupportedOperationException("Cannot redefine singleton server");
        }
        Core.server = server;
    }

    /**
     * Attempts to connect a player to the server and add them to the online player collection
     * @param sessionId the sessionId of the player to connect
     * @param user the user associated
     */
    public static void connectPlayer(String sessionId, User user) {
        server.connectPlayer(sessionId, user);
    }

    /**
     *
     * @param user
     */
    public static void disconnectPlayer(User user) {
        server.disconnectPlayer(user);
    }

    private static void disconnectPlayer(Player player) {
        server.disconnectPlayer(player);
    }

}
