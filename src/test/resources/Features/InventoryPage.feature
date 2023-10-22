@InventoryPage
Feature: Inventory Page
  Scenario: User add to cart some product
    Given User on inventory page
    When User click add to cart button
    Then Item cart will increase