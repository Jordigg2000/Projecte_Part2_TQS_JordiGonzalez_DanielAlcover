Feature: animations

  Background:
    Given access to the main page8

  Scenario: slide main page
    When sliding 4 times
    Then check 5th slide

  Scenario: open 3 bars
    When click on 3 bars
    Then its opened

  Scenario: close 3 bars menu
    When open 3 bars
    When close menu
    Then its closed