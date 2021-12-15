Feature: filters in product search

  Background:
    Given access to the main page5
    When click on capraboacasa button2

  Scenario: select filters 1
    When click on oferta
    When select 3x2
    When select order ZA
    Then check first product

  Scenario: select filters 2
    When click on de la nostra terra
    When select order AZ
    When select oferta
    Then check first product2

  Scenario: select filters 3
    When click on mon nado
    When select order AZ
    When select ALMIRON
    Then check first product3
