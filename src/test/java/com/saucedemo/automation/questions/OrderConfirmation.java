package com.saucedemo.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import com.saucedemo.automation.ui.CheckoutPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OrderConfirmation implements Question<String> {

    public static OrderConfirmation message() {
        return new OrderConfirmation();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.COMPLETE_ORDER_HEADER, isVisible()).forNoMoreThan(10).seconds()
        );
        return Text.of(CheckoutPage.COMPLETE_ORDER_HEADER).answeredBy(actor);
    }
}