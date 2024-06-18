Feature: Home Page Functionality

  Scenario: Check visibility of buttons on the home page
    Given I am on the home page
    Then I should see the "Play" button
    And I should see the "Pause" button
    And I should see the "Next" button
    And I should see the "Previous" button