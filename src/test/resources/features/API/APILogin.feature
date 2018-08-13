@api
Feature: Orchestrator Web Service Login Testing

  Scenario: Login with valid user
    Given I want to open login using tentat "TA_Andromeda", username "admin" and password "Qwerty123"
    When I login into Orchestrator Web Serivce and receive session token
    Then I check that session token is not empty
    
  Scenario: Login with invalid user
    Given I want to open login using tentat "TA_Andromeda", username "admin" and password "Qwerty1234"
    When I login into Orchestrator Web Serivce and receive session token
    Then I check that session token is empty
    
