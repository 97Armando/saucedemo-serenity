@regression
Feature: Complete purchase flow on SauceDemo

  As a standard user
  I want to buy products
  So that I can complete an order

  Scenario: Successful purchase of two items
    Given the user is on the SauceDemo login page
    When the user logs in with "standard_user" and "secret_sauce"
    And the user adds "Sauce Labs Backpack" and "Sauce Labs Bike Light" to the cart
    And the user proceeds to checkout
    And the user fills the checkout information with "John", "Doe" and "12345"
    And the user finalizes the purchase
    Then the user should see the confirmation message "THANK YOU FOR YOUR ORDER"