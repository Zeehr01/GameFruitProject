package hlgamemav;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
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
}
