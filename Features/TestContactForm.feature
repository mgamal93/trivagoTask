
Feature: Contact us feature

  Scenario: As a trivago user I want to send message using contact us
    Given User in home page
    And User Navigated to contact page
    When User enters the name "Mahmoud" and the email "mahmoud.gamal.fcih@gmail.com" and message "Thanks for your response"
    And User confirm the checkbox to click submit
    Then User message should sent successfully  

  