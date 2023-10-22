Feature: Add item to cart
  Scenario: Add two item to cart
    Given I open browser for cart scenario
    And Open website saucedemo for cart scenario
    And Located on saucedemo website for cart scenario
    And I input valid username for cart scenario
    And And I input valid password for cart scenario
    Given I catalog product
    And I add first product to cart
    And I add second product to cart
    Then I should see amount items on cart icon "2"

  Scenario: Add more than 2 item to cart
    Given I open browser for cart scenario
    And Open website saucedemo for cart scenario
    And Located on saucedemo website for cart scenario
    And I input valid username for cart scenario
    And And I input valid password for cart scenario
    Given I catalog product
    And I add first product again to cart
    And I add second product again to cart
    And I add third product to cart
    And I add fourth product to cart
    Then I should see amount items on cart icon after i add 2 items "4"








