package gameFruitImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static gameFruitImplementation.Platform.isGameOnPlatform;
import static gameFruitImplementation.Platform.isPlayerOnPlatform;

public class Lobby {
    private final String name;
    private final ArrayList<Game> games = new ArrayList<>();
    private final ArrayList<Player> players = new ArrayList<>();

    public Lobby(String name) {
        this.name = name;
    }

    public void addGame(Game game) throws Exception {
        if (!isGameOnPlatform(game)) throw new Exception("Game should be available on the platform");
        games.add(game);
    }

    public void removeGame(Game game) throws Exception {
        if (games.size() <= 3) throw new Exception("Could not remove game (3 min required)");
        games.remove(game);
    }

    public void addPlayer(Player player) throws Exception {
        if (!isPlayerOnPlatform(player)) throw new Exception("Player should be on the same platform");
        if (players.size() >= 20) throw new Exception("Could not add player (20 max allowed)");
        players.add(player);
    }

    public void removePlayers(ArrayList<Player> players) throws Exception {
        if (this.players.size() - players.size() <= 1)
            throw new Exception("Could not remove player(s), lobby needs at least 1 player");
        for (Player player : players) {
            this.players.remove(player);
        }
    }

    public Map<String, Integer> getRanking() {
        Map<String, Integer> map = new HashMap<>();
        for (Player player: players) {
            map.put(player.getUsername(), player.getScore());
        }
        return map;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Game> getGames() {
        return games;
    }
}