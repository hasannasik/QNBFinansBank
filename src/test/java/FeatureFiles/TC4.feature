Feature: Verify that they have engineering insurance

  Background:
    Given Navigate To the bank's website
    Then  Verify that you are on their website

  Scenario Outline: Engineering insurance
    Given Enter the "<word>" in the search box
    When  Click on the first link and click on Engineering insurance on the page that appears
    Then  Verify that you are on the right page
    Examples:
      | word |
      |  Sigorta    |


