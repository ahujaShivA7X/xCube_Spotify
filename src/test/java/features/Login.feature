Feature: Login to Spotify App

  @Sanity
  Scenario: Check Login Screen Buttons
    Given I am on the Spotify login page
    Then I should see the "Sign up free" button
    And I should see the "Continue with phone number" button
    And I should see the "Continue with Google" button
    And I should see the "Continue with Facebook" button

  @Regression
  Scenario Outline: Login with valid credentials
    Given I am on the Spotify login page
    When I click the login button
    And I verify the username and password label texts
    And I enter username "<UserName>" and password "<Password>"
    And I click the login button
    Then I should see the home page

    Examples:
      | UserName               | Password   |
      | offo.moti368@gmail.com | Abcd!23456 |
