Feature: Login as a user

Background:
  Given we enter to the web

Scenario: do login in the web
  When we make login with right user and password
  Then the login is successful