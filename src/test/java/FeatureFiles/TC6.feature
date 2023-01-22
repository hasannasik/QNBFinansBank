Feature: Remittance fee control from branch

  Background:
    Given Navigate To the bank's website
    Then  Verify that you are on their website

  Scenario:
    Given Go to the product and fees page
    When  Select one of the Money Transfer options
    Then  View the money transfer details from the branch
