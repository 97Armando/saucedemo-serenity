package com.saucedemo.automation.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import com.saucedemo.automation.tasks.Login;
import com.saucedemo.automation.tasks.AddProductsToCart;
import com.saucedemo.automation.tasks.ProceedToCheckout;
import com.saucedemo.automation.tasks.FillCheckoutForm;
import com.saucedemo.automation.tasks.FinalizePurchase;
import com.saucedemo.automation.questions.OrderConfirmation;

import java.util.List;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class PurchaseFlowStepDefinitions {

    @Before
    public void setTheStage() {OnStage.setTheStage(new OnlineCast());
    }

    @Given("el usuario esta en la pagina de inicio de sesion de SauceDemo")
    public void theUserIsOnTheSauceDemoLoginPage() {
        theActorCalled("Buyer").wasAbleTo(Open.url("https://www.saucedemo.com/"));
    }

    @When("el usuario inicia sesion con {string} y {string}")
    public void theUserLogsInWithAnd(String username, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(username, password)
        );
    }

    @And("el usuario añade {string} y {string} a la cesta")
    public void theUserAddsAndToTheCart(String product1, String product2) {
        theActorInTheSpotlight().attemptsTo(
                AddProductsToCart.withNames(List.of(product1, product2))
        );
    }

    @And("el usuario procede al pago")
    public void theUserProceedsToCheckout() {
        theActorInTheSpotlight().attemptsTo(
                ProceedToCheckout.fromCart()
        );
    }

    @And("el usuario rellena la informacion de pago con {string}, {string} y {string}")
    public void theUserFillsTheCheckoutInformationWithAnd(String firstName, String lastName, String zipCode) {
        theActorInTheSpotlight().attemptsTo(
                FillCheckoutForm.withDetails(firstName, lastName, zipCode)
        );
    }

    @And("el usuario finaliza la compra")
    public void theUserFinalizesThePurchase() {
        theActorInTheSpotlight().attemptsTo(
                FinalizePurchase.now()
        );
    }

    @Then("el usuario deberia ver el mensaje de confirmacion {string}")
    public void theUserShouldSeeTheConfirmationMessage(String expectedMessage) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                OrderConfirmation.message(), equalToIgnoringCase(expectedMessage)
        ));
    }
}