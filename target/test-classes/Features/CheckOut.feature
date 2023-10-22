Feature: Checkout item
  Scenario: Checkout with one selected items
    Given I open browser for checkout scenario
    And Open web saucedemo for checkout scenario
    And Located on saucedemo website for checkout scenario
    And I input valid username for checkout scenario
    And And I input valid password for checkout scenario
    Given Page catalog product
    And And I select one product to cart
    And And I click icon cart
    And And I click checkout button
    Then I should see form information data

  Scenario Outline: Checkout without selected items
    Given I open browser for checkout scenario
    And Open web saucedemo for checkout scenario
    And Located on saucedemo website for checkout scenario
    And I input valid username for checkout scenario
    And And I input valid password for checkout scenario
    Given Page catalog product
    And And I click icon cart
    Then Button checkout must be cannot clicked