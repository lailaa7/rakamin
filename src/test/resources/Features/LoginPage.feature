@LoginPage
Feature:Login Page
  Scenario: User login with valid credentials
    Given User in the sauce demo login page
    When User input valid username
    And User input valid password
    And User click login button
    Then User success login

  Scenario: User login with invalid username
    Given User in the sauce demo login page
    When User input invalid username
    And User input valid password
    And User click login button
    Then User will see error invalid username password message