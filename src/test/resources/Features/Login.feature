Feature: Login to Saucedemo app
  Scenario: Failed Login with empty username
    Given I open browser
    And Open website saucedemo
    And Located on saucedemo website
    When I input empty username
    And I input valid password
    Then I should see error message "Epic sadface: Username is required"

  Scenario: Success Login
    Given I open browser
    And Open website saucedemo
    And Located on saucedemo website
    When I input valid username
    And And I input valid password
    Then I go to homepage