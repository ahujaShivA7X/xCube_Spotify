Feature: Test Search functionality on Spotify

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
