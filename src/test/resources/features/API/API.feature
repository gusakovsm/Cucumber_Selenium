@api
Feature: Orchestrator Web Service Testing

	Background: Receive connection token
    Given I want to open login using tentat "TA_Andromeda", username "admin" and password "Qwerty123"
    When I login into Orchestrator Web Serivce and receive session token
    Then I check that session token is not empty
 
 	Scenario: Create new assets
 		Given I check that session token is not empty
 		When I send request to create new "System name" asset with type "Text" and value "SAP"
 		Then I check response code 201
      
  Scenario: Find specific asset
  	Given I check that session token is not empty
		When I send request to receive all assets data
		Then I check that assets count greater then 0
		And I search asset in assets list by asset name "System name"


