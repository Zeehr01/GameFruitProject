Feature: Players should be able to manage other players in lobby
  Scenario: Add player to lobby
    Given a player
    When Player adds another player to lobby
    Then The player should appear in the lobby player list

  Scenario: Remove player from lobby
    Given a player
    When Player removes another player from lobby
    Then The player should not appear in the lobby player list

  Scenario: Create a list of favourite games
    Given a player
    When Player creates a favourite game list
    Then The list must contain at least one game

  Scenario: Add game to favourite game list
    Given a player
    When Player adds a game to favourite game list
    Then The list must contain the game

  Scenario: Remove game from favourite game list
    Given a player
    When Player removes a game from favourite game list
    Then The list must not contain the game

  Scenario Outline: Update player theme
    Given a player
    When Player updates its color theme to "<color>"
    Then Its preferences should be set to "<color>"

    Examples:
      | color  |
      | RED    |
      | GREEN  |
      | YELLOW |

  Scenario: Invite new player
    Given a player
    When Player invites a new player
    Then The email sending should fail