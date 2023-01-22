Feature: Change and verify page language

  Background:
    Given Navigate To the bank's website
    Then  Verify that you are on their website

  Scenario: Change language
    Given Change Language
    Then  Verify that the page language has changed