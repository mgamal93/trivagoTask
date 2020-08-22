Feature: Test home links

  Scenario: As a trivago user I want to verify that the links in homepage are working
    Given User in home page
    When System navigate to all links
    Then Verify that count of links is equals to "40"
