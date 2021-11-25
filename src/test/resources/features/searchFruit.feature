@tag
Feature: Fruit Search
  As a customer, I want to search for a fruit by name and get its price.
  I want to check if the fruit exists and if I can buy it.

  @tag1
  Scenario Outline: search for fruit
    Given A search bar
    When I search for the fruit with name <fruit> and price <price>
    Then get the name of the fruit if it exists

    Examples:
      | fruit    | price |
      | "Orange" | 3     |
      | "Pomme"  | 2     |


