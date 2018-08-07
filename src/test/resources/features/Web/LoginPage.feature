@webpage @loginpage
Feature: Login Page Testing

  Scenario: Login with invalid user
    Given I want to open Orchestrator
    And I see "Login - UiPath Orchestrator Community" page title
    When I type into tenant "TA_Andromeda", login "admin", password "test123" and press login
    Then I see error message "Invalid username/email address or password."

  Scenario: Reset password
    Given I see "Login - UiPath Orchestrator Community" page title
    When I click reset passowrd
    And I see "Reset Password - UiPath Orchestrator Community" page title
    And I type tenant "TA_Andromeda", login "admin" and click reset
    Then I see error message "Failure sending mail. Please ask an administrator to configure the mail settings."
    And I close Orchestrator
        
  Scenario: Become a tenant
    Given I want to open Orchestrator
    And I see "Login - UiPath Orchestrator Community" page title
    When I click become a tenant
    Then I see "Become a tenant - UiPath Orchestrator Community" page title
    And I go back
    
  Scenario: Open License Agreement
    Given I see "Login - UiPath Orchestrator Community" page title
    When I click Terms and conditions
    Then I see license agreement page "https://www.uipath.com/community-license-agreement"
    And I close this tab
    And I close Orchestrator
    
  Scenario: Login with valid user
    Given I want to open Orchestrator
    And I see "Login - UiPath Orchestrator Community" page title
    When I type into tenant "TA_Andromeda", login "admin", password "Qwerty123" and press login
    Then I see "UiPath Orchestrator Community" page title
    And I LogOut
    And I close Orchestrator





