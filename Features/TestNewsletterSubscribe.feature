Feature: Subscribe to the Newsletter

  Scenario: As a trivago user I want to Subscribe to the Newsletter
    
    Given User in home page
    When User navigated to NEWSLETTER and enteres his email as "mahmoud.gamal.fcih@gmail.com"
    And User click inspire me button
    Then message should be displayed "You are now checked-in!"
