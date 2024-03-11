package starter.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;
import starter.actions.web.HomeActions;
import starter.actions.web.LoginActions;
import starter.actions.web.RegisterActions;
import starter.actions.web.UTILITY_FUNCTIONS;
import starter.pages.web.LoginPage;
import starter.pages.web.DepositPage;
import starter.questions.HomePageQuestions;
import starter.questions.LoginPageQuestions;
import starter.questions.PrimaryPageQuestions;
import starter.questions.RegistrationPageQuestions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.CoreMatchers.anyOf;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static starter.steps.database.databaseStepDefinitions.checkUserExists;

public class webStepDefinitions {

    @And("{actor} ensures username {string} and password {string} account exists")
    public void userEnsuresUsernameUsernameAccountExists(Actor actor, String username, String password) {
        actor.attemptsTo(
                Check.whether(!checkUserExists(username))
                        .andIfSo(
                                LoginActions.clickSignUp(),
                                RegisterActions.enterFirstName(username),
                                RegisterActions.enterLastName(username),
                                RegisterActions.enterPhone(username),
                                RegisterActions.enterEmail(username),
                                RegisterActions.enterUsername(username),
                                RegisterActions.enterPassword(password),
                                RegisterActions.clickSignUp()
                        )
        );
        UTILITY_FUNCTIONS.WaitForSignInHeader.toAppear();
    }

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
        UTILITY_FUNCTIONS.WaitForSignInHeader.toAppear();
    }

    @Then("{actor} redirects to login page")
    public void userRedirectsToLoginPage(Actor actor) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase("index")
        );
    }

    @Then("{actor} redirects to Sign up page")
    public void userRedirectsToSignUpPage(Actor actor) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase("signup")
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

    @Then("{actor} should see sign in elements")
    public void userShouldSeeSignInElements(Actor actor) {
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

    @Then("{actor} should see sign up elements")
    public void userShouldSeeSignUpElements(Actor actor) {
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

    @Then("{actor} registration should be unsuccessful")
    public void userRegistrationShouldBeUnsuccessful(Actor actor) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).doesNotContain("index")
        );
        actor.should(
                seeThat(RegistrationPageQuestions.isEmailExistMessageVisible(), Matchers.equalTo(false)),
                seeThat(RegistrationPageQuestions.isUsernameExistMessageVisible(), Matchers.equalTo(false))
        );
    }

    @And("{actor} clicks show password")
    public void userClicksShowPassword(Actor actor) {
        actor.attemptsTo(
                RegisterActions.clickShowPassword()
        );
    }

    @Then("{actor} should see password not masked")
    public void userShouldSeePasswordNotMasked(Actor actor) {
        actor.should(
                seeThat(RegistrationPageQuestions.isPasswordMasked(), Matchers.equalTo(false))
        );
    }

    @Then("{actor} should see existing error message")
    public void userShouldSeeExistingErrorMessage(Actor actor) {
        actor.should(
                seeThat(RegistrationPageQuestions.isEmailOrUsernameExistMessageVisible())
        );
    }

    @Then("{actor} should see Please fill out this fill message")
    public void userShouldSeePleaseFillOutThisFillMessage(Actor actor) {
        // pending
    }

    @And("{actor} checks Remember Me checkbox")
    public void userChecksRememberMeCheckbox(Actor actor) {
        actor.attemptsTo(
                LoginActions.clickRememberMe()
        );
    }

    @And("{actor} logout")
    public void userLogout(Actor actor) {
        actor.attemptsTo(
                HomeActions.autoLogoutFromHomePage()
        );
    }

    @Then("{actor} should see {string} on the username field")
    public void userShouldSeeUsernameOnTheUsernameField(Actor actor, String username) {
        actor.attemptsTo(
                Ensure.that(LoginPage.USERNAME_FIELD).hasText(username)
        );
    }

    @Then("{actor} should see Dashboard page elements")
    public void userShouldSeeDashboardPageElements(Actor actor) {
        actor.should(
                seeThat(HomePageQuestions.isCloudBankLogoVisible()),
                seeThat(HomePageQuestions.isMainMenuHomeVisible()),
                seeThat(HomePageQuestions.isMainMenuAccountsVisible()),
                seeThat(HomePageQuestions.isMainMenuTransferVisible()),
                seeThat(HomePageQuestions.isMainMenuAppointmentVisible()),
                seeThat(HomePageQuestions.isMainMenuMeVisible()),
                seeThat(HomePageQuestions.isPrimaryAccountBalanceVisible()),
                seeThat(HomePageQuestions.isPrimaryAccountViewDetailsButtonVisible()),
                seeThat(HomePageQuestions.isSavingsAccountBalanceVisible()),
                seeThat(HomePageQuestions.isSavingsAccountViewDetailsButtonVisible()),
                seeThat(HomePageQuestions.isGoToDepositButtonVisible()),
                seeThat(HomePageQuestions.isGoToWithdrawalButtonVisible())
        );
    }

    @When("{actor} clicks Savings Balance View Details")
    public void userClicksSavingsBalanceViewDetails(Actor actor) {
        actor.attemptsTo(
                HomeActions.navigateToSavingsAccountViewDetails()
        );
    }

    @Then("{actor} should see Savings Balance page")
    public void userShouldSeeSavingsBalancePage(Actor actor) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase("account/savingsAccount")
        );
    }

    @When("{actor} clicks Deposit View Details")
    public void userClicksDepositViewDetails(Actor actor) {
        actor.attemptsTo(
                HomeActions.navigateToDepositViewDetails()
        );
    }

    @Then("{actor} should see Deposit page")
    public void userShouldSeeDepositPage(Actor actor) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase("account/deposit")
        );
    }

    @When("{actor} clicks Withdrawal View Details")
    public void userClicksWithdrawalViewDetails(Actor actor) {
        actor.attemptsTo(
                HomeActions.navigateToWithdrawalViewDetails()
        );
    }

    @Then("{actor} should see Withdrawal page")
    public void userShouldSeeWithdrawalPage(Actor actor) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase("account/withdraw")
        );
    }

    @When("{actor} clicks dropdown {string} and option {string}")
    public void userClicksDropdownDropdownAndOptionOption(Actor actor, String dropdown, String option) {
        actor.attemptsTo(
                HomeActions.openDropdownAndNavigateToOption(dropdown, option)
        );
    }

    @Then("{actor} should see url {string} page")
    public void userShouldSeeUrlUrlPage(Actor actor, String url) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase(url)
        );
    }

    @Then("{actor} should see Deposit page elements")
    public void userShouldSeeDepositPageElements(Actor actor) {
        String expectedText = "2. Please specify the amount you would like to deposit:";
        actor.attemptsTo(
                Ensure.that(DepositPage.ACCOUNT_TYPE_DROPDOWN).isDisplayed(),
                Ensure.that(DepositPage.SPECIFY_AMOUNT_TEXT).hasText(expectedText),
                Ensure.that(DepositPage.DEPOSIT_BUTTON).isDisplayed()
        );
    }
}
