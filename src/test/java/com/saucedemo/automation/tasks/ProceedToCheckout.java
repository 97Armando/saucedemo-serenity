package com.saucedemo.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import com.saucedemo.automation.ui.ProductsPage;
import com.saucedemo.automation.ui.ShoppingCartPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProceedToCheckout implements Task {

    public static ProceedToCheckout fromCart() {
        return instrumented(ProceedToCheckout.class);
    }

    @Override
    @Step("{0} proceeds to checkout")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ProductsPage.SHOPPING_CART_LINK, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ProductsPage.SHOPPING_CART_LINK),
                WaitUntil.the(ShoppingCartPage.CHECKOUT_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ShoppingCartPage.CHECKOUT_BUTTON)
        );
    }
}