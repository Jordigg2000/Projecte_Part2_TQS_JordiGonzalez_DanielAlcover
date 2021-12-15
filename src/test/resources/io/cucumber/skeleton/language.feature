Feature: language
  Background:
    Given access to the main page9


  Scenario: change language in caprabo.com
  When select castellano in caprabo
  Then caprabo is in castellano

Scenario: change language in capraboacasa.com
  When click on capraboacasa button4
  When select catalan in capraboacasa
  Then capraboacasa is in catalan

  Scenario: change language in xefcaprabo.com
    When click on xefcaprabo button
    When select castellano in xefcaprabo
    Then xefcaprabo is in castellano
