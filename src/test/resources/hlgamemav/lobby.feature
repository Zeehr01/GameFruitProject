Feature: Players should be able to manage lobby
  Scenario: Create lobby
    Given a player
    When Player adds lobby
    Then The lobby is added to the platform list

  Scenario: Create more than 10 lobbies
    Given a player
    When Player adds lobby
    Then The lobby is added to the platform list

  Scenario: Remove lobby
    Given a player
    When Player removes lobby
    Then The lobby should not appear in the platform list

  Scenario: Get ranking
    Given a player
    When Player asks for ranking
    Then The ranking should contain every players with their score