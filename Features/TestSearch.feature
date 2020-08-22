Feature: Search

  Scenario: As a trivago user I want to  search for any location on magazine by using the search bar
    Given User in home page
    When User enters search key "Arizona"
    Then User should find the search result successfully
