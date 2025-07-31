package com.saucedemo.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage {
    public static final Target ADD_TO_CART_BUTTON = Target.the("add to cart button")
            .locatedBy("//button[text()='Add to cart']");
    public static final Target SHOPPING_CART_BADGE = Target.the("shopping cart badge")
            .located(By.className("shopping_cart_badge"));
    public static final Target SHOPPING_CART_LINK = Target.the("shopping cart link")
            .located(By.className("shopping_cart_link"));

    public static Target addToCartButtonForProduct(String productName) {
        return Target.the("Add to cart button for " + productName)
                .locatedBy("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button");
    }
}