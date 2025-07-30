package com.saucedemo.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShoppingCartPage {
    public static final Target CHECKOUT_BUTTON = Target.the("checkout button").located(By.id("checkout"));
    public static final Target PRODUCT_ITEM_NAME = Target.the("product item name")
            .locatedBy("//div[@class='inventory_item_name']");
}