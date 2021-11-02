Feature: Players should be able to manage games in lobby

  Scenario: Add game to lobby
    Given a player
    When Player adds a game to lobby
    Then The game should appear in the lobby game list

  Scenario: Add game on different platform to lobby
    Given a player
    When Player adds a game to lobby on a different platform
    Then An exception should be thrown

  Scenario: Remove game from lobby
    Given a player
    When Player removes a game from lobby
    Then The game should not appear in the lobby game list

  Scenario: Add players to game
    Given a player
    When Player adds players to game
    Then The players should appear in the game list

  Scenario: Update rules
    Given a player
    When Player updates the rules
    Then The new rules should appear in the list