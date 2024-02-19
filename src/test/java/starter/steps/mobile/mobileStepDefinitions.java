package starter.steps.mobile;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.remote.DesiredCapabilities;
import starter.actions.web.LoginActions;
import starter.questions.HomePageQuestions;
import java.net.MalformedURLException;
import java.net.URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
public class mobileStepDefinitions {
    @Given("{actor} is on the mobile login page")
    public void userIsOnTheMobileLoginPage(Actor actor) {
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
}