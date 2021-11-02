package hlgamemav;

import java.util.ArrayList;

public class Game {
    private final String name;
    private final ArrayList<Player> players = new ArrayList<>();
    private ArrayList<String> rules = new ArrayList<>();

    public Game(String name) {
        this.name = name;
    }

    public void addPlayers(ArrayList<Player> players) throws Exception {
        if ((this.players.size() + players.size()) > 5)
            throw new Exception("A game cannot contain more than 5 players");
        this.players.addAll(players);
    }

    public void updateRules(ArrayList<String> rules) {
        this.rules = rules;
    }

    public ArrayList<String> getRules() {
        return rules;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }
}
