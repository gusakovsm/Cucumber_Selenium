@webpage @assetpage
Feature: Assets page testing

  Scenario: Create new String Asset
    Given I Open Orchestrator and Login into tenant "TA_Andromeda" using login "admin" and password "Qwerty123"
    And I click "assets" button
    When I see "Assets - UiPath Orchestrator Community" page title
    And I create new asset "AssetString" with String type and value "StringText"
    Then I search created asset by asset name "AssetString" and check that asset with this value exist

  Scenario: Create new Integer Asset
  	Given I see "Assets - UiPath Orchestrator Community" page title
  	When I create new asset "AssetInteger" with Integer type and value 2018
  	Then I search created asset by asset name "AssetInteger" and check that asset with this value exist
  	
  Scenario: Create new Bool Asset
    Given I see "Assets - UiPath Orchestrator Community" page title
    When I create new asset "AssetBoolean" with Boolean type and value "True"
    Then I search created asset by asset name "AssetBoolean" and check that asset with this value exist
    
  Scenario: Create new Credential Asset
  	Given I see "Assets - UiPath Orchestrator Community" page title
    When I create new asset "AssetCredentials" with Credentials type, username "Username" and password "Password"
    Then I search created asset by asset name "AssetCredentials" and check that asset with this value exist
    And I LogOut
    And I close Orchestrator
    
  