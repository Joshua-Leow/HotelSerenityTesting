package starter.steps.mobile;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import starter.actions.web.HomeActions;
import starter.actions.web.LoginActions;
import starter.actions.web.RegisterActions;
import starter.questions.HomePageQuestions;
import starter.questions.LoginPageQuestions;
import starter.questions.PrimaryPageQuestions;
import starter.questions.RegistrationPageQuestions;

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

    @Then("{actor} should see Error Message displayed {string} on the mobile")
    public void userShouldSeeErrorMessageDisplayedOnTheMobile(Actor actor, String input) {
        String pageSource = (String) BrowseTheWeb.as(actor).evaluateJavascript("return document.documentElement.outerHTML");
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase("error"),
                Ensure.that(pageSource).containsIgnoringCase(input)
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

    @And("{actor} clicks Cancel Register button on the mobile")
    public void userClicksCancelRegisterButtonOnTheMobile(Actor actor) {
        actor.attemptsTo(
                RegisterActions.clickCancelRegister()
        );
    }

    @Then("{actor} redirects to login page on the mobile")
    public void userRedirectsToLoginPageOnTheMobile(Actor actor) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase("index")
        );
    }

    @When("{actor} clicks Primary Balance View Details on the mobile")
    public void userClicksPrimaryBalanceViewDetailsOnTheMobile(Actor actor) {
        actor.attemptsTo(
                HomeActions.navigateToPrimaryAccountViewDetails()
        );
    }

    @Then("{actor} should see Primary Balance page on the mobile")
    public void userShouldSeePrimaryBalancePageOnTheMobile(Actor actor) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase("account/primaryAccount")
        );
        actor.should(
                seeThat(PrimaryPageQuestions.isPrimaryAccountViewDetailsVisible())
        );
    }

    @Then("{actor} should see sign in elements on the mobile")
    public void userShouldSeeSignInElementsOnTheMobile(Actor actor) {
        actor.should(
                seeThat(LoginPageQuestions.isCloudBankLogoVisible()),
                seeThat(LoginPageQuestions.isSignInLablelVisible()),
                seeThat(LoginPageQuestions.isUsernameFieldVisible()),
                seeThat(LoginPageQuestions.isPasswordFieldVisible()),
                seeThat(LoginPageQuestions.isRememberMeCheckboxVisible()),
                seeThat(LoginPageQuestions.isSignInButtonVisible()),
                seeThat(LoginPageQuestions.isSignUpButtonVisible())
        );
    }

    @Then("{actor} should see sign up elements on the mobile")
    public void userShouldSeeSignUpElementsOnTheMobile(Actor actor) {
        actor.should(
                seeThat(RegistrationPageQuestions.isFirstNameFieldVisible()),
                seeThat(RegistrationPageQuestions.isLastNameFieldVisible()),
                seeThat(RegistrationPageQuestions.isPhoneFieldVisible()),
                seeThat(RegistrationPageQuestions.isEmailFieldVisible()),
                seeThat(RegistrationPageQuestions.isUsernameFieldVisible()),
                seeThat(RegistrationPageQuestions.isPasswordFieldVisible()),
                seeThat(RegistrationPageQuestions.isShowPasswordCheckboxVisible()),
                seeThat(RegistrationPageQuestions.isSignUpButtonVisible()),
                seeThat(RegistrationPageQuestions.isCancelButtonVisible())
        );
    }
}