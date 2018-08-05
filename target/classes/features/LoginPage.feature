@sample
Feature: Login Page Testing
  
  Scenario: Login with valid user
    Given I want to open Orchestrator
    And Login into tenant "TA_Andromeda" using login "admin" and password "Qwerty123"
    When I type credentials and press login
    Then I see Orchestrator Home page


  Scenario: Login with invalid user
    Given I want to open Orchestrator
    And Login into tenant "TA_Andromeda" using login "admin" and password "test123"
    When I type credentials and press login
    Then I see Orchestrator Login page

