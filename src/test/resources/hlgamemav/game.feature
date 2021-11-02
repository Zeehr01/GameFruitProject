Feature: Game handling

  Scenario: Add game to lobby
    Given a player, 1 platform, 1 lobby, 1 game and 0 other player on same platform
    When Player adds a game to lobby
    Then The game should appear in the lobby game list

  Scenario: Add game on different platform to lobby
    Given a player, 1 platform, 1 lobby, 1 game and 0 other player
    When Player adds a game to lobby
    Then An exception is thrown with message "Game should be available on the platform"

  Scenario: Remove game from lobby
    Given a player, 1 platform, 1 lobby, 4 games and 0 other player on same platform
    When Player removes a game from lobby
    Then The game should not appear in the lobby game list

  Scenario: Remove game from lobby when remaining only 3 games in lobby
    Given a player, 1 platform, 1 lobby, 3 games and 0 other player
    When Player removes a game from lobby
    Then An exception is thrown with message "Could not remove game (3 min required)"

  Scenario: Add players to game
    Given a player, 1 platform, 1 lobby, 1 game and 2 other players on same platform
    When Player adds other players to game
    Then The players should appear in the game list

  Scenario: Add more than 5 players to game
    Given a player, 1 platform, 1 lobby, 1 game and 6 other players on same platform
    When Player adds other players to game
    Then An exception is thrown with message "A game cannot contain more than 5 players"

  Scenario: Update rules
    Given a player, 1 platform, 1 lobby, 1 game and 0 other player on same platform
    When Player updates the rules
    Then The new rules should appear in the list