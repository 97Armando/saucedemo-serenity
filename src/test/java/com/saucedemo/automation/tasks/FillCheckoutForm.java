package com.saucedemo.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;
import com.saucedemo.automation.ui.CheckoutPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillCheckoutForm implements Task {

    private final String firstName;
    private final String lastName;
    private final String zipCode;

    public FillCheckoutForm(String firstName, String lastName, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    public static FillCheckoutForm withDetails(String firstName, String lastName, String zipCode) {
        return instrumented(FillCheckoutForm.class, firstName, lastName, zipCode);
    }

    @Override
    @Step("{0} rellena el formulario de pago con los datos: #firstName, #lastName, #zipCode")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.FIRST_NAME_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME_FIELD),
                Enter.theValue(zipCode).into(CheckoutPage.ZIP_CODE_FIELD),
                Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }
}