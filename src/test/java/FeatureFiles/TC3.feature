Feature: Control of instant market data
  Background:
    Given Navigate To the bank's website
    Then  Verify that you are on their website


  Scenario:  Checking the market data on the homepage
    Given    Navigate to Market Data And Check Data
    Then     Save data to excel


