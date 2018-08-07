@webpage @mainmenu
Feature: Main Menu Testing

  Scenario: All main menu button checking for correct page opening by Title and URL
    Given I Open Orchestrator and Login into tenant "TA_Andromeda" using login "admin" and password "Qwerty123"
    When I click "robots" button
    Then I see "Robots - UiPath Orchestrator Community" page title
    And Page URL should contain "/robots" end the URL end
    When I click "processes" button
    Then I see "Processes - UiPath Orchestrator Community" page title
    And Page URL should contain "/processes" end the URL end
    When I click "jobs" button
    Then I see "Jobs - UiPath Orchestrator Community" page title
    And Page URL should contain "/jobs" end the URL end
    When I click "schedules" button
    Then I see "Schedules - UiPath Orchestrator Community" page title
    And Page URL should contain "/schedules" end the URL end
    When I click "assets" button
    Then I see "Assets - UiPath Orchestrator Community" page title
    And Page URL should contain "/assets" end the URL end
    When I click "queues" button
	  Then I see "Queues - UiPath Orchestrator Community" page title
	  And Page URL should contain "/queues" end the URL end
	  When I click UiPath logo
	  Then I see "UiPath Orchestrator Community" page title
	  And Page URL should contain "" end the URL end
    And I LogOut
    And I close Orchestrator
