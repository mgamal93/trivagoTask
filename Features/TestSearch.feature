Feature: Search

  Scenario: As a trivago user I want to  Search for any location on Magazine by using the search bar
    Given User in home page
    When User enters search key "Arizona"
    Then User should find the search result successfully
