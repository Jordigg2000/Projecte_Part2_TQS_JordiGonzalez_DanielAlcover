Feature: write
  Background:
    Given access to the main page3

  Scenario: Click on search
    When click on Caprabo a casa
    When write vodka on Cercador
    Then check url

  Scenario: choose supermarket from the list
    When clink on supermarket localizer
    When choose city
    Then right supermarket appears

  Scenario: search llet
    When click and select Diccionari
    When write llet and descobrir
    Then you got the milk
