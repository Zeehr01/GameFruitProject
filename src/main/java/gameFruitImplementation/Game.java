package gameFruitImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game implements StoreItems {
  private  String name;
  private int price;
  private final ArrayList<Player> players = new ArrayList<>();
  private ArrayList<String> rules = new ArrayList<>();
  public Map<String, Integer> gamesMap() {
        Map<String, Integer> dictionaryGames = new HashMap<String, Integer>();
        dictionaryGames.put("Monopoly", 100);
        dictionaryGames.put("Careers", 173);
        dictionaryGames.put("FIFA22", 500);
        dictionaryGames.put("Mario", 95);
        dictionaryGames.put("Sudoku", 50);
        return dictionaryGames;
    }

  public Game(String name) {
    this.name = name;
  }
    public Game() {
        this.name = "";
        this.price=0;
    }

  public Game(String name, int price) {
    this.name = name;
    this.price = price;
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

  @Override
  public boolean buy(String name, int price) {
      Game game=new Game();
      if (game.gamesMap().containsKey(name)) {
          if (game.gamesMap().get(name) <= price) {
              return true;
          }
      }
      return false;
  }
}
