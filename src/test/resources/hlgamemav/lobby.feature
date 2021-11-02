Feature: Lobby handling

  Scenario: Create lobby
    Given a player, 1 platform, 0 lobby, 0 game and 0 other player on same platform
    When Player creates 1 lobby
    Then 1 lobby have been added to the platform list

  Scenario: Create more than 10 lobbies
    Given a player, 1 platform, 0 lobby, 0 game and 0 other player on same platform
    When Player creates 11 lobbies
    Then An exception is thrown with message "Could not create lobby (10 max per player)"

  Scenario: Remove lobby
    Given a player, 1 platform, 2 lobbies, 0 game and 0 other player
    When Player removes lobby
    Then The lobby should not appear in the platform list

  Scenario: Remove last lobby
    Given a player, 1 platform, 1 lobbies, 0 game and 0 other player
    When Player removes lobby
    Then An exception is thrown with message "Could not remove lobby, player should at least be in 1 lobby"

  Scenario: Get ranking
    Given a player, 1 platform, 1 lobbies, 0 game and 0 other player
    When Player asks for ranking
    Then The ranking should contain every players with their score