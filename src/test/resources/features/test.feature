@tag
Feature: Get your preferred items from the store

  @tag1
  Scenario: get an item according to your hobby
    Given you get in the store
    When you look for an item in the store according to your <passion>
    Then get the name of the item <item>

  Scenario: buy a game or a fruit
    Given a game or a fruit in the store
    When you want to buy a game or a fruit of a given name and price
    Then we verify if you can buy it or not