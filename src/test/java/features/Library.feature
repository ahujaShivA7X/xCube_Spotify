Feature: Navigate to your library

  Scenario: Navigate to Your Library in Spotify
    Given I start the Appium server and emulator
    And I am on the Spotify login page
    When I enter username and password
    And I click the login button
    And I go to the Your Library page
    Then I should see the Your Library page