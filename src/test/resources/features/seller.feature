@tag
Feature: Adding fruit into Seller's list
  En tant que vendeur je veux recuperer la liste des fruits dans la quantite eagle a 0
  Afin de controler son stock de fruits et faire les achat necessaires

  @tag1
  Scenario: add a fruit into Seller's list of fruits
    Given a seller
    When he wants to add a fruit into his list
    Then verifiy if the fruit is added into his list

  Scenario: sell a fruit
    Given a seller
    When he wants to sell a fruit
    Then if the fruit exists on his store he will sell it otherwise he wont
