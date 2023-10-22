@CartPage
Feature:Cart Page
  Scenario: User remove product
    Given User on inventory page
    When User click add to cart button
    And User move to cart page
    When User click remove button
    Then Item cart will decrease