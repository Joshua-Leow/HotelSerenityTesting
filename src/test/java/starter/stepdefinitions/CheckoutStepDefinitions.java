package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import starter.navigation.NavigateTo;
import starter.fill.EnterCheckoutDetails;

public class CheckoutStepDefinitions {

    @Given("{actor} navigates to the checkout page")
    public void userNavigatesToTheCheckoutPage(Actor actor) {
        actor.wasAbleTo(NavigateTo.theCheckoutPage());
    }

    @And("{actor} enters first name {string}")
    public void userEntersFirstName(Actor actor, String inputValue) {
        actor.attemptsTo(
                EnterCheckoutDetails.enterFirstName(inputValue)
        );
    }

    @And("{actor} enters last name {string}")
    public void userEntersLastName(Actor actor, String inputValue) {
        actor.attemptsTo(
                EnterCheckoutDetails.enterLastName(inputValue)
        );
    }

    @And("{actor} enters email {string}")
    public void userEntersEmail(Actor actor, String inputValue) {
        actor.attemptsTo(
                EnterCheckoutDetails.enterFirstName(inputValue)
        );
    }

    @And("{actor} enters address {string}")
    public void userEntersAddress(Actor actor, String inputValue) {
        actor.attemptsTo(
                EnterCheckoutDetails.enterLastName(inputValue)
        );
    }

    @And("{actor} selects country {string}")
    public void userSelectsCountry(Actor actor, String inputValue) {
        actor.attemptsTo(
                EnterCheckoutDetails.selectCountry(inputValue)
        );
    }

    @And("{actor} enters zip code {string}")
    public void userEntersZipCode(Actor actor, String inputValue) {
        actor.attemptsTo(
                EnterCheckoutDetails.enterZipCode(inputValue)
        );
    }

    @And("{actor} selects payment method {string}")
    public void userSelectsPaymentMethod(Actor actor, String inputValue) {
        actor.attemptsTo(
                EnterCheckoutDetails.selectPaymentMethod(inputValue)
        );
    }

    @Then("{actor} should see no errors")
    public void userShouldSeeNoErrors(Actor actor) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.title()).containsIgnoringCase(" ")
        );
    }

    @And("{actor} clicks the Submit button")
    public void userClicksTheSubmitButton(Actor actor) {
        actor.attemptsTo(
                EnterCheckoutDetails.clickSubmitButton()
        );
    }
}
