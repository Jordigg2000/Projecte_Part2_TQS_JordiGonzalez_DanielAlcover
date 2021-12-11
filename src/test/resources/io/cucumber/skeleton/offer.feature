Feature: offer

  Background:
    Given access to the main page3

  Scenario: go to offer
    When click on ofertes i promocions
    When click on ofertes
    When write postal code
    Then it is written correctly