package starter.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.actions.web.LoginActions;
import starter.questions.HomePageQuestions;

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
}
