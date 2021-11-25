package gameFruitImplementation;

import java.util.ArrayList;

public class Platform {
    private final String name;
    private static final ArrayList<Player> players = new ArrayList<>();
    private static final ArrayList<Lobby> lobbies = new ArrayList<>();
    private static final ArrayList<Game> games = new ArrayList<>();

    public Platform(String name) {
        this.name = name;
    }

    public void addLobbyToPlatform(Lobby lobby) {
        lobbies.add(lobby);
    }

    public void addGameToPlatform(Game game) {
        games.add(game);
    }

    public void addPlayerToPlatform(Player player) {
        players.add(player);
    }

    public static boolean isGameOnPlatform(Game game) {
        return games.contains(game);
    }

    public static boolean isPlayerOnPlatform(Player player) {
        return players.contains(player);
    }

    public ArrayList<Lobby> getLobbies() {
        return lobbies;
    }
}