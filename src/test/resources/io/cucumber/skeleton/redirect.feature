Feature: redirect

  Background:
    Given access to the main page2

  Scenario: go to important data about caprabo
    When click on caprabo info button
    When click on main data
    Then it is in the right page

  Scenario: go to capraboacasa.com beverages
    When click on productores
    When click on begudes
    Then it is in the capraboacasa page

  Scenario: go to bienvenidaMatrona
    When click on BenvingudaLlevadora
    Then is is in the bienvenidaMatrona page