Feature: Subscribe to the Newsletter

  Scenario: As a trivago user I want to subscribe to the newsletter
    Given User in home page
    When User navigated to NEWSLETTER and enteres his email as "mg06@mailinator.com"
    And User click inspire me button
    Then message should be displayed "You are now checked-in!"
