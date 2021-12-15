Feature: search
  Background:
    Given access to the main page6
    When click on capraboacasa button3

  Scenario:search leche
    When search leche
    Then check first product4

  Scenario: search carn
    When search carne
    Then check first product5

  Scenario: search huevos
    When search huevos
    Then check first product6
