Feature: filters blog

  Background:
    Given access to the main page10
    Given go to blog page

  Scenario: december
    When choose date
    Then check first entrance

  Scenario: september
    When choose date2
    Then check first entrance2

  Scenario: may
    When choose date3
    Then check first entrance3
