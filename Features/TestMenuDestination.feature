Feature: Menu Destinations 

  Scenario: As a trivago user I want to navigate to a destination through the menu on the top left
  
    Given User in home page
    When User click on menu button
    And User expand a destinations menu item and select a specific destination 
    Then User should be redirected to the specific destination page