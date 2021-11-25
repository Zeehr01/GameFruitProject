package testRunner;

import gameFruitImplementation.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    private Exception exception;
    private Player player;
    private Map<String, Integer> ranking;
    private ArrayList<Platform> platforms;
    private ArrayList<Lobby> lobbies;
    private ArrayList<Game> games;
    private ArrayList<Player> players;
    private Customer gamer;
    private Customer vendeur;
    private StoreItemsFactory StoreItem;
    private StoreItems fruit;
    private Fruit fruit1;
    private Fruit fruit2;
    private StoreItems game;
    private Game monopoly;
    private Fruit Orange;
    private boolean buyMonoploy;
    private boolean buyOrange;
    private boolean AddOrange;
    private boolean delOrange;
    private Seller seller;

    @Given("a player, {int} platform(s), {int} lobby,/lobbies, {int} game(s) and {int} other player(s)")
    public void aPlayerPlatformsLobbiesGamesAndOtherPlayers(int platformNb, int lobbyNb, int gameNb, int playerNb) {
        player = new Player("Jean");
        platforms = new ArrayList<>();
        for (int i = 0; i < platformNb; i++) {
            platforms.add(new Platform("Platform " + i));
        }
        lobbies = new ArrayList<>();
        for (int i = 0; i < lobbyNb; i++) {
            lobbies.add(new Lobby("Lobby " + i));
        }
        games = new ArrayList<>();
        for (int i = 0; i < gameNb; i++) {
            games.add(new Game("Game " + i));
        }
        players = new ArrayList<>();
        for (int i = 0; i < playerNb; i++) {
            players.add(new Player("Player " + i));
        }
    }

    @Given("a player, {int} platform(s), {int} lobby,/lobbies, {int} game(s) and {int} other player(s) on same platform")
    public void aPlayerPlatformsLobbiesGamesAndOtherPlayersOnSamePlatform(int platformNb, int lobbyNb, int gameNb, int playerNb) {
        aPlayerPlatformsLobbiesGamesAndOtherPlayers(platformNb, lobbyNb, gameNb, playerNb);
        for (Platform platform : platforms) {
            for (Game game : games) {
                platform.addGameToPlatform(game);
            }
            for (Player player : players) {
                platform.addPlayerToPlatform(player);
            }
        }
    }

    @When("Player adds a game to lobby")
    public void playerAddsAGameToLobby() {
        try {
            player.addGameToLobby(lobbies.get(0), games.get(0));
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("The game should appear in the lobby game list")
    public void theGameShouldAppearInTheLobbyGameList() {
        assertTrue(lobbies.get(0).getGames().contains(games.get(0)));
    }

    @Then("An exception is thrown with message {string}")
    public void anExceptionIsThrownWithMessage(String message) {
        assertEquals(exception.getMessage(), message);
    }

    @When("Player removes a game from lobby")
    public void playerRemovesAGameFromLobby() {
        try {
            player.removeGameFromLobby(lobbies.get(0), games.get(0));
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("The game should not appear in the lobby game list")
    public void theGameShouldNotAppearInTheLobbyGameList() {
        assertFalse(lobbies.get(0).getGames().contains(games.get(0)));
    }

    @When("Player adds other player(s) to game")
    public void playerAddsOtherPlayersToGame() {
        try {
            player.addPlayersToGame(games.get(0), players);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("The players should appear in the game list")
    public void thePlayersShouldAppearInTheGameList() {
        for (Player player : players) {
            assertTrue(games.get(0).getPlayers().contains(player));
        }
    }

    @When("Player updates the rules")
    public void playerUpdatesTheRules() {
        ArrayList<String> rules = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rules.add("Rule " + i);
        }
        player.updateRules(games.get(0), rules);
    }

    @Then("The new rules should appear in the list")
    public void theNewRulesShouldAppearInTheList() {
        for (int i = 0; i < 10; i++) {
            assertEquals("Rule " + i, games.get(0).getRules().get(i));
        }
    }

    @When("Player creates {int} lobby/lobbies")
    public void playerCreatesLobbies(int lobbyNb) {
        try {
            for (int i = 0; i < lobbyNb; i++) {
                player.createLobby(platforms.get(0), "Lobby " + i);
            }
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("{int} lobby/lobbies has/have been added to the platform list")
    public void theLobbyIsAddedToThePlatformList(int lobbyNb) {
        assertEquals(lobbyNb, platforms.get(0).getLobbies().size());
    }

    @When("Player removes lobby")
    public void playerRemovesLobby() {
        try {
            player.removeLobby(lobbies.get(0));
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("The lobby should not appear in the platform list")
    public void theLobbyShouldNotAppearInThePlatformList() {
        assertFalse(platforms.get(0).getLobbies().contains(lobbies.get(0)));
    }

    @When("Player asks for ranking")
    public void playerAsksForRanking() {
        ranking = player.getRanking(lobbies.get(0));
    }

    @Then("The ranking should contain every players with their score")
    public void theRankingShouldContainEveryPlayersWithTheirScore() {
        for (Map.Entry<String, Integer> map : ranking.entrySet()) {
            assertEquals("Jean", map.getKey());
            assertEquals(0, map.getValue());
        }
    }

    @When("Player adds other player(s) to lobby")
    public void playerAddsOtherPlayersToLobby() {
        try {
            for (Player player : players) {
                player.addPlayerToLobby(lobbies.get(0), player);
            }
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("The player should appear in the lobby player list")
    public void thePlayerShouldAppearInTheLobbyPlayerList() {
        for (Player player : players) {
            assertTrue(lobbies.get(0).getPlayers().contains(player));
        }
    }

    @When("Player removes another player from lobby")
    public void playerRemovesAnotherPlayerFromLobby() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(this.players.get(0));
        try {
            player.removePlayersFromLobby(lobbies.get(0), players);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("The player should not appear in the lobby player list")
    public void thePlayerShouldNotAppearInTheLobbyPlayerList() {
        assertFalse(lobbies.get(0).getPlayers().contains(players.get(0)));
    }

  @When("Player creates a favourite game list")
  public void playerCreatesAFavouriteGameList() {
    try {
      player.createFavouriteGameList(games);
    } catch (Exception e) {
      exception = e;
    }
  }

  @Then("The list must contain at least one game")
  public void theListMustContainAtLeastOneGame() {
    assertTrue(player.getFavouriteGames().contains(games.get(0)));
  }

  @When("Player adds a game to favourite game list")
  public void playerAddsAGameToFavouriteGameList() {
    try {
      for (Game game : games) {
        player.addFavouriteGame(game);
      }
    } catch (Exception e) {
      exception = e;
    }
  }

  @Then("The list must contain the game")
  public void theListMustContainTheGame() {
    assertTrue(player.getFavouriteGames().contains(games.get(0)));
  }

  @When("Player removes a game from favourite game list")
  public void playerRemovesAGameFromFavouriteGameList() {
    try {
      player.removeFavouriteGame(games.get(0));
    } catch (Exception e) {
      exception = e;
    }
  }

  @Then("The list must not contain the game")
  public void theListMustNotContainTheGame() {
    assertFalse(player.getFavouriteGames().contains(games.get(0)));
  }

  @When("Player updates its color theme to {string}")
  public void playerUpdatesItsColorThemeTo(String color) {
    player.updateColorPreferences(Color.valueOf(color));
  }

  @Then("Its preferences should be set to {string}")
  public void itsPreferencesShouldBeSetTo(String color) {
    assertEquals(player.getColor().toString(), color);
  }

  @When("Player invites a new player")
  public void playerInvitesANewPlayer() {
    try {
      player.inviteNewPlayer("eric@gmail.com");
    } catch (Exception e) {
      exception = e;
    }
  }

  @Given("you get in the store")
  public void you_get_in_the_store() {
    StoreItem = new StoreItemsFactory();
  }

  @When("you look for an item in the store according to your <passion>")
  public void you_look_for_an_item_in_the_store_according_to_your_passion() {
    game = StoreItem.getPreferedItems("geek");
    fruit = StoreItem.getPreferedItems("baker");
  }

  @Then("get the name of the item <item>")
  public void get_the_name_of_the_item_item() {
    assertEquals(game.getClass(), Game.class);
    assertEquals(fruit.getClass(), Fruit.class);
  }

    @Given("a customer")
    public void a_customer() {
        gamer = new Player();
        vendeur = new Seller();
    }

    @When("you get into a store")
    public void you_get_into_a_store() {
        System.out.println("You get in the store");
    }

    @Then("Get your profession<profession>")
    public void get_your_profession_profession() {
        Assertions.assertEquals(gamer.getProfession(), "Player");
        Assertions.assertEquals(vendeur.getProfession(), "Seller");
    }

    @Then("you will know if you get into the game")
    public void you_will_know_if_you_get_into_the_game() {
        Assertions.assertEquals(gamer.goToGame(), true);
        Assertions.assertEquals(vendeur.goToGame(), false);
    }

    @Then("or into the fruitStore")
    public void or_into_the_fruit_store() {
        Assertions.assertEquals(gamer.goToFruit(), false);
        Assertions.assertEquals(vendeur.goToFruit(), true);
    }

    @Given("the fruit stock and a search bar")
    public void the_fruit_stock_and_a_search_bar() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("Step1: Le client est dans la page de recherche ");
    fruit1 = new Fruit();
  }

    @When("I search for fruits whose quantity equals {int}")
    public void i_search_for_fruits_whose_quantity_equals(Integer quantite) {
    // Write code here that turns the phrase above into concrete actions
    quantite = 0;
    System.out.println("Step2:Rechercher les fruits qui ont une quantite egale a " + quantite);
  }

    @Then("retrieve the list of fruit names {string},{string},{string}.")
    public void retrieve_the_list_of_fruit_names(String arg1, String arg2, String arg3) {
    // Write code here that turns the phrase above into concrete actions
    System.out.println(
        "Step3: les fruits avec les noms  "
            + arg1
            + " "
            + " "
            + arg2
            + " "
            + arg3
            + " "
            + "et avec quantite est nulle doivent etre affiché.");
    List<String> fruitsnondispo = fruit1.getNonDispoFruits();
    List<String> expected = Arrays.asList(arg1, arg2, arg3);
    List<String> actual = fruitsnondispo;
    assertEquals(actual, expected);
  }

  @Given("A search bar")
  public void i_have_a_list_of_fruits() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("Step1: Le client est dans la page de recherche ");
  }

    @When("I search for the fruit with name {string} and price {int}")
    public void i_search_for_the_fruit_with_name_and_price(String fruitName, Integer price) {
    fruit2 = new Fruit(fruitName, price);
  }

    @Then("get the name of the fruit if it exists")
    public void get_the_name_of_the_fruit_if_it_exists() {
    // Write code here that turns the phrase above into concrete actions
    String name = fruit2.searchFruit(fruit2);
    assertEquals(fruit2.getName(), name);
  }

  @Given("a game or a fruit in the store")
  public void a_game_or_a_fruit_in_the_store() {
    // Write code here that turns the phrase above into concrete actions
    monopoly = new Game();
    Orange = new Fruit();
  }

  @When("you want to buy a game or a fruit of a given name and price")
  public void you_want_to_buy_a_game_or_a_fruit_of_a_given_name_and_price() {
    buyMonoploy = monopoly.buy("Monoploy", 50);
    buyOrange = Orange.buy("Orange", 10);
  }

  @Then("we verify if you can buy it or not")
  public void we_verify_if_you_can_buy_it_or_not() {
    assertEquals(buyMonoploy, false);
    assertEquals(buyOrange, true);
  }

  @Given("a seller")
  public void a_seller() {
    seller = new Seller();
  }

  @When("he wants to add a fruit into his list")
  public void he_want_to_add_a_fruit_into_his_list() {
    AddOrange = seller.addFruit(Orange);
  }

  @Then("verifiy if the fruit is added into his list")
  public void verifiy_if_the_fruit_is_added_into_his_list() {
    Assertions.assertEquals(AddOrange, true);
  }

  @When("he wants to sell a fruit")
  public void he_wants_to_sell_a_fruit() {
    // Write code here that turns the phrase above into concrete actions
    delOrange = seller.fruitVendu(Orange);
  }

  @Then("if the fruit exists on his store he will sell it otherwise he wont")
  public void if_the_fruit_exists_on_his_store_he_will_sell_it_otherwise_he_wont() {
    // Write code here that turns the phrase above into concrete actions
    Assertions.assertEquals(delOrange, false);
  }
}
