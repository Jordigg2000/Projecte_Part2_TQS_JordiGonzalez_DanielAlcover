Feature: login

  Background:
    Given access to the main page

  Scenario: insert wrong user
    Given being in the login page
    When login with wrong user and right password
    Then the login is not successful

  Scenario: insert wrong password
    Given being in the login page
    When login with right user and wrong password
    Then the login is not successful