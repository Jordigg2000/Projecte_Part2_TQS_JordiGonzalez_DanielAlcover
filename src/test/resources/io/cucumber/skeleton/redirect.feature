Feature: redirect

  Background:
    Given access to the main page2

  Scenario: go to important data about caprabo
    When click on caprabo info button
    When click on main data
    Then it is in the right page