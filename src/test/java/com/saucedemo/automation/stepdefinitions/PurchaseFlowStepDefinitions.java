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
    public void setTheStage() {
        OnStage.setAcutors(new OnlineCast());
    }

    @Given("the user is on the SauceDemo login page")
    public void theUserIsOnTheSauceDemoLoginPage() {
        theActorCalled("Buyer").wasAbleTo(Open.url("https://www.saucedemo.com/"));
    }

    @When("the user logs in with {string} and {string}")
    public void theUserLogsInWithAnd(String username, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(username, password)
        );
    }

    @And("the user adds {string} and {string} to the cart")
    public void theUserAddsAndToTheCart(String product1, String product2) {
        theActorInTheSpotlight().attemptsTo(
                AddProductsToCart.withNames(List.of(product1, product2))
        );
    }

    @And("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        theActorInTheSpotlight().attemptsTo(
                ProceedToCheckout.fromCart()
        );
    }

    @And("the user fills the checkout information with {string}, {string} and {string}")
    public void theUserFillsTheCheckoutInformationWithAnd(String firstName, String lastName, String zipCode) {
        theActorInTheSpotlight().attemptsTo(
                FillCheckoutForm.withDetails(firstName, lastName, zipCode)
        );
    }

    @And("the user finalizes the purchase")
    public void theUserFinalizesThePurchase() {
        theActorInTheSpotlight().attemptsTo(
                FinalizePurchase.now()
        );
    }

    @Then("the user should see the confirmation message {string}")
    public void theUserShouldSeeTheConfirmationMessage(String expectedMessage) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                OrderConfirmation.message(), equalToIgnoringCase(expectedMessage)
        ));
    }
}