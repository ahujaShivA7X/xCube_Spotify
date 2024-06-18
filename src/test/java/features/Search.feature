Feature: Search songs in spotify

  Scenario: Search in Spotify
    Given I start the Appium server and emulator
    And I am on the Spotify login page
    And I enter username "offo.moti368@gmail.com" and password "Abcd!23456"
    And I click the login button
    And I go to the search page and search for "Beatles"
    Then I should see search results