Feature: LOGIN

Scenario: insert wrong user
  Given being in the login page
  When login with wrong user and right password
  Then the login is not successful