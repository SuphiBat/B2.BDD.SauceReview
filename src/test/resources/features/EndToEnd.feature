@smoke
Feature: E2E Test

  @wip
  Scenario: End to End Test
    Given The user is on the login page
    When The user enters "standard_user" and "secret_sauce"
    Then The user should be able to login and see "Products" header
    When The user sorts products as "Price (high to low)"
    And The user adds the cheapest as "7.99" and the second costliest as "29.99"
    And The user opens basket
    And The user clicks on checkout
    And The user enters details as "John" "Wick" "09400" and finishes the purchase
    Then The user verifies that the items are "Total: $41.02"