Feature: Consumer loan calculation

  Background:
    Given Navigate To the bank's website
    Then  Verify that you are on their website

  Scenario:
    Given Enter the required values
    |krediTutariHome|10000|
    Then  Verify credit has been calculated
