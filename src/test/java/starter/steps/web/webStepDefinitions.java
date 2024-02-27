package starter.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import starter.actions.web.HomeActions;
import starter.actions.web.LoginActions;
import starter.actions.web.RegisterActions;
import starter.questions.HomePageQuestions;
import starter.questions.PrimaryPageQuestions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class webStepDefinitions {

    @Given("{actor} is logged in with username {string} and password {string}")
    public void userIsLoggedIn(Actor actor, String username, String password) {
        actor.attemptsTo(
                LoginActions.navigateToLoginPage(),
                LoginActions.enterUserName(username),
                LoginActions.enterUserPassword(password),
                LoginActions.clickSignIn()
        );
    }

    @Given("{actor} is on the login page")
    public void userIsOnTheLoginPage(Actor actor) {
        actor.attemptsTo(
                LoginActions.navigateToLoginPage()
        );
    }

    @When("{actor} input username {string} and password {string}")
    public void userInputUsernameUsernameAndPasswordPassword(Actor actor, String username, String password) {
        actor.attemptsTo(
                LoginActions.enterUserName(username),
                LoginActions.enterUserPassword(password)
        );
    }

    @And("{actor} submit the login form")
    public void userSubmitTheLoginForm(Actor actor) {
        actor.attemptsTo(
                LoginActions.clickSignIn()
        );
    }

    @Then("{actor} should be authenticated successfully")
    public void userShouldBeAuthenticatedSuccessfully(Actor actor) {
        actor.should(
                seeThat(HomePageQuestions.isPrimaryAccountViewDetailsButtonVisible())
        );
    }

    @Then("{actor} should see Error Message displayed {string}")
    public void userShouldSeeErrorMessageDisplayed(Actor actor, String input) {
        String pageSource = (String) BrowseTheWeb.as(actor).evaluateJavascript("return document.documentElement.outerHTML");
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase("error"),
                Ensure.that(pageSource).containsIgnoringCase(input)
        );
    }

    @When("{actor} clicks Sign Up button")
    public void userClicksSignUpButton(Actor actor) {
        actor.attemptsTo(
                LoginActions.clickSignUp()
        );
    }

    @And("{actor} enters first name {string}")
    public void userEntersFirstName(Actor actor, String firstname) {
        actor.attemptsTo(
                RegisterActions.enterFirstName(firstname)
        );
    }

    @And("{actor} enters last name {string}")
    public void userEntersLastName(Actor actor, String lastname) {
        actor.attemptsTo(
                RegisterActions.enterLastName(lastname)
        );
    }

    @And("{actor} enters phone {string}")
    public void userEntersPhone(Actor actor, String phone) {
        actor.attemptsTo(
                RegisterActions.enterPhone(phone)
        );
    }

    @And("{actor} enters email {string}")
    public void userEntersEmail(Actor actor, String email) {
        actor.attemptsTo(
                RegisterActions.enterEmail(email)
        );
    }

    @And("{actor} enters username {string}")
    public void userEntersUsername(Actor actor, String username) {
        actor.attemptsTo(
                RegisterActions.enterUsername(username)
        );
    }

    @And("{actor} enters password {string}")
    public void userEntersPassword(Actor actor, String password) {
        actor.attemptsTo(
                RegisterActions.enterPassword(password)
        );
    }

    @And("{actor} clicks Sign Up Register button")
    public void userClicksSignUpRegisterButton(Actor actor) {
        actor.attemptsTo(
                RegisterActions.clickSignUp()
        );
    }

    @Then("{actor} redirects to login page")
    public void userRedirectsToLoginPage(Actor actor) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase("index")
        );
    }

    @And("{actor} clicks Cancel Register button")
    public void userClicksCancelRegisterButton(Actor actor) {
        actor.attemptsTo(
                RegisterActions.clickCancelRegister()
        );
    }

    @When("{actor} clicks Primary Balance View Details")
    public void userClicksPrimaryBalanceViewDetails(Actor actor) {
        actor.attemptsTo(
                HomeActions.navigateToPrimaryAccountViewDetails()
        );
    }

    @Then("{actor} should see Primary Balance page")
    public void userShouldSeePrimaryBalancePage(Actor actor) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase("account/primaryAccount")
        );
        actor.should(
                seeThat(PrimaryPageQuestions.isPrimaryAccountViewDetailsVisible())
        );
    }
}
