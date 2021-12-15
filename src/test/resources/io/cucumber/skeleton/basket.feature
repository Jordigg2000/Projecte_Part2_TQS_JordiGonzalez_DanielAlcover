Feature: basket

  Background:
    Given access to the main page4
    When click on capraboacasa button

  Scenario: add water to the basket
    When click on water
    When add water to the basket
    Then the total price increases 3,6

  Scenario: add oil to the basket
    When click on oil
    When add oil to the basket
    Then the total price increases 4,99

  Scenario: add ribs to the basket
    When click on fet a la botiga
    When add ribs to the basket
    Then the total price increases 4,00
