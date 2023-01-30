Feature: Go to the bank's French site and check
  Background:
    Given Navigate To the bank's website
    Then  Verify that you are on their website

  @SmokeTest
  Scenario:
    Given Go to the French site
    Then  Verify that the page has changed