package com.saucedemo.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import com.saucedemo.automation.ui.CheckoutPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FinalizePurchase implements Task {

    public static FinalizePurchase now() {
        return instrumented(FinalizePurchase.class);
    }

    @Override
    @Step("{0} finalizes the purchase")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.FINISH_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }
}