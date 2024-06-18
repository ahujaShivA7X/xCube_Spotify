Feature: Login to Spotify App

  Scenario: Check Login Screen Buttons
    Given I start the Appium server and emulator
    And I am on the Spotify login page
    Then I should see the "Sign up free" button
    And I should see the "Continue with phone number" button
    And I should see the "Continue with Google" button
    And I should see the "Continue with Facebook" button

  Scenario: Login with valid credentials
    Given I start the Appium server and emulator
    And I am on the Spotify login page
    When I click the login button
    And I verify the username and password label texts
    And I enter username "offo.moti368@gmail.com" and password "Abcd!23456"
    Then I should see the home page