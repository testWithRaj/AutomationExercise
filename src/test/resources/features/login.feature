Feature: Login Functionality on AutomationExercise

  Scenario: Login with valid credentials
    Given user launches the browser
    When user is on home page
    And user clicks on login link
    And user enters email "rajk116629@gmail.com" and password "password12345"
    And user clicks on login button
    Then user should land on account page

  Scenario: Login with invalid credentials
    Given user launches the browser
    When user is on home page
    And user clicks on login link
    And user enters email "rajk116629@gmail.com" and password "password123456"
    And user clicks on login button
    Then error message should be displayed
