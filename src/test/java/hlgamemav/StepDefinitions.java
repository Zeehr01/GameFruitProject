package hlgamemav;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    private Exception exception;
    private Platform platform;
    private Lobby lobby1;
    private Lobby lobby2;
    private Player player1;
    private Player player2;
    private Game game1;
    private Game game2;
    private Map<String, Integer> ranking;

    public StepDefinitions() throws Exception {
        game1 = new Game("FIFA 2022");
        game2 = new Game("Dofus");
        platform = new Platform("PS5");
        platform.addGameToPlatform(game1);
        lobby1 = new Lobby("Lobby 1");
        lobby2 = new Lobby("Lobby 2");
        lobby2.addGame(game1);
        for (int i = 0; i < 3; i++) {
            Game game = new Game("Game " + i);
            platform.addGameToPlatform(game);
            lobby2.addGame(game);
        }
        player2 = new Player("Christophe");
    }

    @Given("a player")
    public void aPlayer() {
        player1 = new Player("Jean");
    }

    @When("Player adds a game to lobby")
    public void playerAddsAGameToLobby() throws Exception {
        player1.addGameToLobby(lobby1, game1);
    }

    @Then("The game should appear in the lobby game list")
    public void theGameShouldAppearInTheLobbyGameList() {
        assertTrue(lobby1.getGames().contains(game1));
    }

    @When("Player adds a game to lobby on a different platform")
    public void playerAddsAGameToLobbyOnADifferentPlatform() {
        try {
            player1.addGameToLobby(lobby1, game2);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("An exception should be thrown")
    public void anExceptionShouldBeThrown() {
        assertEquals(exception.getMessage(), "Game should be available on the platform");
    }

    @When("Player removes a game from lobby")
    public void playerRemovesAGameFromLobby() throws Exception {
        player1.removeGameFromLobby(lobby2, game1);
    }

    @Then("The game should not appear in the lobby game list")
    public void theGameShouldNotAppearInTheLobbyGameList() {
        assertFalse(lobby2.getGames().contains(game1));
    }

    @When("Player adds players to game")
    public void playerAddsPlayersToGame() throws Exception {
        player1.addPlayerToLobby(lobby1, player2);
    }

    @Then("The players should appear in the game list")
    public void thePlayersShouldAppearInTheGameList() {
        assertTrue(lobby1.getPlayers().contains(player2));
    }

    @When("Player updates the rules")
    public void playerUpdatesTheRules() {
        ArrayList<String> rules = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rules.add("Rule " + i);
        }
        player1.updateRules(game1, rules);
    }

    @Then("The new rules should appear in the list")
    public void theNewRulesShouldAppearInTheList() {
        for (int i = 0; i < 10; i++) {
            assertEquals("Rule " + i, game1.getRules().get(i));
        }
    }

    @When("Player adds lobby")
    public void playerAddsLobby() {
    }

    @Then("The lobby is added to the platform list")
    public void theLobbyIsAddedToThePlatformList() {
    }

    @When("Player removes lobby")
    public void playerRemovesLobby() throws Exception {
        player1.removeLobby(lobby1);
    }

    @Then("The lobby should not appear in the platform list")
    public void theLobbyShouldNotAppearInThePlatformList() {
    }

    @When("Player asks for ranking")
    public void playerAsksForRanking() {
        ranking = player1.getRanking(lobby1);
    }

    @Then("The ranking should contain every players with their score")
    public void theRankingShouldContainEveryPlayersWithTheirScore() {
        for (Map.Entry<String, Integer> map : ranking.entrySet()) {
            assertEquals("Jean", map.getKey());
            assertEquals(0, map.getValue());
        }
    }

    @When("Player adds another player to lobby")
    public void playerAddsAnotherPlayerToLobby() throws Exception {
        player1.addPlayerToLobby(lobby1, player2);
    }

    @Then("The player should appear in the lobby player list")
    public void thePlayerShouldAppearInTheLobbyPlayerList() {
        assertTrue(lobby1.getPlayers().contains(player2));
    }

    @When("Player removes another player from lobby")
    public void playerRemovesAnotherPlayerFromLobby() throws Exception {
        ArrayList<Player> players = new ArrayList<>();
        players.add(player2);
        player1.removePlayersFromLobby(lobby1, players);
    }

    @Then("The player should not appear in the lobby player list")
    public void thePlayerShouldNotAppearInTheLobbyPlayerList() {
        assertFalse(lobby1.getPlayers().contains(player2));
    }

    @When("Player creates a favourite game list")
    public void playerCreatesAFavouriteGameList() throws Exception {
        ArrayList<Game> games = new ArrayList<>();
        games.add(game1);
        player1.createFavouriteGameList(games);
    }

    @Then("The list must contain at least one game")
    public void theListMustContainAtLeastOneGame() {
        assertTrue(player1.getFavouriteGames().contains(game1));
    }

    @When("Player adds a game to favourite game list")
    public void playerAddsAGameToFavouriteGameList() throws Exception {
        player1.addFavouriteGame(game1);
    }

    @Then("The list must contain the game")
    public void theListMustContainTheGame() {
        assertTrue(player1.getFavouriteGames().contains(game1));
    }

    @When("Player removes a game from favourite game list")
    public void playerRemovesAGameFromFavouriteGameList() throws Exception {
        player1.removeFavouriteGame(game1);
    }

    @Then("The list must not contain the game")
    public void theListMustNotContainTheGame() {
        assertFalse(player1.getFavouriteGames().contains(game1));
    }

    @When("Player updates its color theme to {string}")
    public void playerUpdatesItsColorThemeTo(String arg0) {
        player1.updateColorPreferences(Color.valueOf(arg0));
    }

    @Then("Its preferences should be set to {string}")
    public void itsPreferencesShouldBeSetTo(String arg0) {
        assertEquals(player1.getColor().toString(), arg0);
    }

    @When("Player invites a new player")
    public void playerInvitesANewPlayer() {
        try {
            player1.inviteNewPlayer("eric@gmail.com");
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("The email sending should fail")
    public void theEmailSendingShouldFail() {
        assertEquals(exception.getClass(), UnsupportedOperationException.class);
    }
}
