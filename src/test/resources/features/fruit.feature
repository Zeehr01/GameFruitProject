Feature: Fruit Not Available
  As a seller I want to get the list of fruits in the quantity eagle to 0
  In order to control the stock of fruit and make the necessary purchases

  @tag1
  Scenario Outline: recovering fruit from depleted stock
    Given the fruit stock and a search bar
    When I search for fruits whose quantity equals 0
    Then retrieve the list of fruit names <fruits>.


    Examples: 
      | fruits|
      | "Kiwi","kaki","banane" |


