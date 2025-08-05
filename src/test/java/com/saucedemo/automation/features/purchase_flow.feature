@regression
Feature: Flujo de compra completo en SauceDemo

  Como usuario estándar
  Quiero comprar productos
  Para poder completar un pedido

  Scenario Outline: Compra de dos articulos con multiples usuarios
    Given el usuario esta en la pagina de inicio de sesion de SauceDemo
    When el usuario inicia sesion con "<username>" y "<password>"
    And el usuario añade "Sauce Labs Backpack" y "Sauce Labs Bike Light" a la cesta
    And el usuario procede al pago
    And el usuario rellena la informacion de pago con "John", "Maldonado" y "12345"
    And el usuario finaliza la compra
    Then el usuario deberia ver el mensaje de confirmacion "Thank you for your order!"

    Examples:
      | username       | password      |
      | standard_user  | secret_sauce  |
      | performance_glitch_user | secret_sauce |
      | visual_user | secret_sauce |