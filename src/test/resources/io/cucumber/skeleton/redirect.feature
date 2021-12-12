Feature: redirect

  Background:
    Given access to the main page2

  Scenario: go to important data about caprabo
    When click on caprabo info button
    When click on main data
    Then it is in the right page

  Scenario: go to caprabo's facebook page
    When click on facebook button
    Then it is in caprabo's facebook page

  Scenario: go to capraboacasa.com
    When click on productores
    When click on dulces y desayunos
    Then it is in the capraboacasa page