package hlgamemav;

import java.util.ArrayList;

public class Platform {
    private final String name;
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<Lobby> lobbies = new ArrayList<>();
    private static ArrayList<Game> games = new ArrayList<>();

    public Platform(String name) {
        this.name = name;
    }

    public void addGameToPlatform(Game game) {
        games.add(game);
    }

    public static boolean isGameOnPlatform(Game game) {
        return games.contains(game);
    }

    public static boolean isPlayerOnPlatform(Player player) {
        return players.contains(player);
    }
}
