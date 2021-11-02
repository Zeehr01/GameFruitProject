package hlgamemav;

import java.util.ArrayList;
import java.util.Map;

public class Player {
    private final String username;
    private int score;
    private Color color;
    private final ArrayList<Lobby> lobbies = new ArrayList<>();
    private final ArrayList<Game> favouriteGames = new ArrayList<>();

    public Player(String username) {
        this.username = username;
    }

    public void createLobby(String name) throws Exception {
        if (lobbies.size() >= 10) throw new Exception("Could not create lobby (10 max per player)");
        Lobby lobby = new Lobby(name);
        lobby.addPlayer(this);
        lobbies.add(lobby);
    }

    public void removeLobby(Lobby lobby) throws Exception {
        for (Player player : lobby.getPlayers()) {
            if (player.lobbies.size() <= 1)
                throw new Exception("Could not remove lobby, players should be at least in 1 lobby");
        }
        lobbies.remove(lobby);
    }

    public void addGameToLobby(Lobby lobby, Game game) throws Exception {
        lobby.addGame(game);
    }

    public void removeGameFromLobby(Lobby lobby, Game game) throws Exception {
        lobby.removeGame(game);
    }

    public void addPlayerToLobby(Lobby lobby, Player player) throws Exception {
        lobby.addPlayer(player);
    }

    public void removePlayersFromLobby(Lobby lobby, ArrayList<Player> players) throws Exception {
        lobby.removePlayers(players);
    }

    public void addPlayersToGame(Game game, ArrayList<Player> players) throws Exception {
        game.addPlayers(players);
    }

    public Map<String, Integer> getRanking(Lobby lobby) {
        return lobby.getRanking();
    }

    public void updateRules(Game game, ArrayList<String> rules) {
        game.updateRules(rules);
    }

    public void createFavouriteGameList(ArrayList<Game> games) throws Exception {
        if (games.size() <= 1)
            throw new Exception("Could not create favourite game list, it should contain at least 1 game");
        favouriteGames.addAll(games);
    }

    public void addFavouriteGame(Game game) throws Exception {
        if (favouriteGames.size() >= 10)
            throw new Exception("Could not add game to favourite game list (10 max per player)");
        favouriteGames.add(game);
    }

    public void removeFavouriteGame(Game game) throws Exception {
        if (favouriteGames.size() <= 1)
            throw new Exception("Could remove game from favourite game list, it should contain at least 1 game");
        favouriteGames.remove(game);
    }

    public void updateColorPreferences(Color color) {
        this.color = color;
    }

    public void inviteNewPlayer(String email) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<Game> getFavouriteGames() {
        return favouriteGames;
    }
}
