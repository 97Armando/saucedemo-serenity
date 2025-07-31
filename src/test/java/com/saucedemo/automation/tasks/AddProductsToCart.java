package com.saucedemo.automation.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import com.saucedemo.automation.ui.ProductsPage;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProductsToCart implements Task {

    private final List<String> productNames;

    public AddProductsToCart(List<String> productNames) {
        this.productNames = productNames;
    }

    public static AddProductsToCart withNames(List<String> productNames) {
        return instrumented(AddProductsToCart.class, productNames);
    }

    @Override
    @Step("{0} añade productos al carrito: #productNames")
    public <T extends Actor> void performAs(T actor) {
        for (String productName : productNames) {
            actor.attemptsTo(
                    WaitUntil.the(ProductsPage.addToCartButtonForProduct(productName), isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(ProductsPage.addToCartButtonForProduct(productName))
            );
        }
    }
}