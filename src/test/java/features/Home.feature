Feature: Verify home page of Spotify

  @Home
  Scenario: Home page verification
    Given I am on the home page
    Then user should see the "Select Podcasts" button
    Then user should see the "Profile" button
    Then user should see the "Premium" button
    Then user should see the "Home" button