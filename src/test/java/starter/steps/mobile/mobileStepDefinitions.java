package starter.steps.mobile;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import starter.actions.web.LoginActions;
import starter.actions.web.RegisterActions;
import starter.questions.HomePageQuestions;
import java.net.MalformedURLException;
import java.net.URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
public class mobileStepDefinitions {
    @Given("{actor} is on the mobile login page")
    public void userIsOnTheMobileLoginPage(Actor actor) {
        actor.attemptsTo(
                LoginActions.navigateToLoginPage()
        );
    }
    @When("{actor} input username {string} and password {string} on the mobile")
    public void userInputUsernameUsernameAndPasswordPasswordOnTheMobile(Actor actor, String username, String password) {
        actor.attemptsTo(
                LoginActions.enterUserName(username),
                LoginActions.enterUserPassword(password)
        );
    }
    @And("{actor} submit the login form on the mobile")
    public void userSubmitTheLoginFormOnTheMobile(Actor actor) {
        actor.attemptsTo(
                LoginActions.clickSignIn()
        );
    }
    @Then("{actor} should be authenticated successfully on the mobile")
    public void userShouldBeAuthenticatedSuccessfullyOnTheMobile(Actor actor) {
        actor.should(
                seeThat(HomePageQuestions.isPrimaryAccountViewDetailsButtonVisible())
        );
    }

    @When("{actor} clicks Sign Up button on the mobile")
    public void userClicksSignUpButtonOnTheMobile(Actor actor) {
        actor.attemptsTo(
                LoginActions.clickSignUp()
        );
    }

    @And("{actor} enters first name {string} on the mobile")
    public void userEntersFirstNameOnTheMobile(Actor actor, String firstname) {
        actor.attemptsTo(
                RegisterActions.enterFirstName(firstname)
        );
    }

    @And("{actor} enters last name {string} on the mobile")
    public void userEntersLastNameOnTheMobile(Actor actor, String lastname) {
        actor.attemptsTo(
                RegisterActions.enterLastName(lastname)
        );
    }

    @And("{actor} enters phone {string} on the mobile")
    public void userEntersPhoneOnTheMobile(Actor actor, String phone) {
        actor.attemptsTo(
                RegisterActions.enterPhone(phone)
        );
    }

    @And("{actor} enters email {string} on the mobile")
    public void userEntersEmailOnTheMobile(Actor actor, String email) {
        actor.attemptsTo(
                RegisterActions.enterEmail(email)
        );
    }

    @And("{actor} enters username {string} on the mobile")
    public void userEntersUsernameOnTheMobile(Actor actor, String username) {
        actor.attemptsTo(
                RegisterActions.enterUsername(username)
        );
    }

    @And("{actor} enters password {string} on the mobile")
    public void userEntersPasswordOnTheMobile(Actor actor, String password) {
        actor.attemptsTo(
                RegisterActions.enterPassword(password)
        );
    }

    @And("{actor} clicks Sign Up Register button on the mobile")
    public void userClicksSignUpRegisterButtonOnTheMobile(Actor actor) {
        actor.attemptsTo(
                RegisterActions.clickSignUp()
        );
    }

    @Then("{actor} redirects to login page on the mobile")
    public void userRedirectsToLoginPageOnTheMobile(Actor actor) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase("index")
        );
    }
}