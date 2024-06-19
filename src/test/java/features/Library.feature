Feature: Navigate to your library

  Scenario: Navigate to Your Library in Spotify
    And I am on the Spotify login page
    And I enter username "<UserName>" and password "<Password>"
    And I click the login button
    And I go to the Your Library page
    Then I should see the Your Library page