@regression
Feature: Flujo de compra completo en SauceDemo

  As a standard user
  I want to buy products
  So that I can complete an order

  Scenario: Compra de dos articulos
    Given el usuario esta en la pagina de inicio de sesion de SauceDemo
    When el usuario inicia sesion con "visual_user" y "secret_sauce"
    And el usuario añade "Sauce Labs Backpack" y "Sauce Labs Bike Light" a la cesta
    And el usuario procede al pago
    And el usuario rellena la informacion de pago con "John", "Maldonado" y "12345"
    And el usuario finaliza la compra
    Then el usuario deberia ver el mensaje de confirmacion "Thank you for your order!"