Feature: Player handling

  Scenario: Add player to lobby
    Given a player, 1 platform, 1 lobby, 0 game and 1 other player on same platform
    When Player adds other player to lobby
    Then The player should appear in the lobby player list

  Scenario: Add different platform player to lobby
    Given a player, 1 platform, 1 lobby, 1 game and 1 other player
    When Player adds other player to lobby
    Then An exception is thrown with message "Player should be on the same platform"

  Scenario: Add more than 20 players to lobby
    Given a player, 1 platform, 1 lobby, 1 game and 21 other players on same platform
    When Player adds other players to lobby
    Then An exception is thrown with message "Could not add player (20 max allowed)"

  Scenario: Remove player from lobby
    Given a player, 1 platform, 1 lobby, 0 game and 2 other players on same platform
    When Player removes another player from lobby
    Then The player should not appear in the lobby player list

  Scenario: Remove last player from lobby
    Given a player, 1 platform, 1 lobby, 0 game and 1 other player on same platform
    When Player removes another player from lobby
    Then An exception is thrown with message "Could not remove player(s), lobby needs at least 1 player"

  Scenario: Create a list of favourite games
    Given a player, 1 platform, 1 lobby, 1 game and 0 other player on same platform
    When Player creates a favourite game list
    Then The list must contain at least one game

  Scenario: Create empty list of favourite games
    Given a player, 1 platform, 1 lobby, 0 game and 0 other player on same platform
    When Player creates a favourite game list
    Then An exception is thrown with message "Could not create favourite game list, it should contain at least 1 game"

  Scenario: Add game to favourite game list
    Given a player, 1 platform, 1 lobby, 1 game and 0 other player on same platform
    When Player adds a game to favourite game list
    Then The list must contain the game

  Scenario: Add more than 10 games to favourite game list
    Given a player, 1 platform, 1 lobby, 11 games and 0 other player on same platform
    When Player adds a game to favourite game list
    Then An exception is thrown with message "Could not add game to favourite game list (10 max per player)"

  Scenario: Remove game from favourite game list
    Given a player, 1 platform, 1 lobby, 1 game and 0 other player on same platform
    When Player removes a game from favourite game list
    Then The list must not contain the game

  Scenario: Remove last game from favourite game list
    Given a player, 1 platform, 1 lobby, 1 game and 0 other player on same platform
    When Player removes a game from favourite game list
    Then An exception is thrown with message "Could remove game from favourite game list, it should contain at least 1 game"

  Scenario Outline: Update player theme
    Given a player, 0 platform, 0 lobby, 0 game and 0 other player
    When Player updates its color theme to "<color>"
    Then Its preferences should be set to "<color>"

    Examples:
      | color  |
      | RED    |
      | GREEN  |
      | YELLOW |

  Scenario: Invite new player
    Given a player, 0 platform, 0 lobby, 0 game and 0 other player
    When Player invites a new player
    Then An exception is thrown with message "Not implemented yet"