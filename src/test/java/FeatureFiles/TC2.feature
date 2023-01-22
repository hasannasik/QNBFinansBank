Feature: Check the number of bank branches and branch addresses in the entered province

  Background:
    Given Navigate To the bank's website
    Then  Verify that you are on their website

  Scenario Outline: Find a bank branch
    Given Click on ATM and Branchs Buttons
    And   Choose your city
      | sendText | <CityName> |
    And   Choose your District
      | sendText | <DistrictName> |
    And   Click search button and view the list
    Examples:
      | CityName | DistrictName |
      | Mersin   | Mezitli       |






