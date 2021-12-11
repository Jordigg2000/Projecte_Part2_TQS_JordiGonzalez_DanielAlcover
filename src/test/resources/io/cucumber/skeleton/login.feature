Feature: login

  Background:
    Given access to the main page
    Given being in the login page

  Scenario: insert wrong user
    When login with wrong user and right password
    Then the login is not successful

  Scenario: insert wrong password
    When login with right user and wrong password
    Then the login is not successful

  Scenario: insert correct values
    When we make login with right user and password
    Then the login is successful