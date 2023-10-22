Feature: Fill checkout information data
  Scenario: Fill form information data use valid data
    Given I open browser for information data scenario
    And Open web saucedemo for information data scenario
    And Located on saucedemo website for information data scenario
    And I input valid username for information data scenario
    And And I input valid password for information data scenario
    Given I catalog product page
    And And I add one product to cart
    And I click icon cart
    And I click checkout button
    And I see form information data
    And I input valid first name
    And I input valid last name
    And I input valid postal code
    And I click button continue
    Then I should see check out over view page

  Scenario Outline: Fill form information data use invalid format data postal code
    Given I open browser for information data scenario
    And Open web saucedemo for information data scenario
    And Located on saucedemo website for information data scenario
    And I input valid username for information data scenario
    And And I input valid password for information data scenario
    Given I catalog product page
    And And I add one product to cart
    And I click icon cart
    And I click checkout button
    And I see form information data
    And I input valid first name again
    And I input valid last name again
    And I input invalid format data postal code
    Then Button must be cannot clicked

