Feature: write
  Background:
    Given access to the main page3

  Scenario: Click on search
    When click on Caprabo a casa
    When write vodka on Cercador
    Then check url
