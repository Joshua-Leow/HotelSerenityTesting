package starter.steps.as400;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.Performable;
import starter.actions.as400.CheckTextFromTerminal;
import starter.actions.as400.InitializeTerminalSession;
import starter.actions.as400.LoginToTerminal;
import starter.actions.as400.NavigateOnTerminal;
import static org.assertj.core.api.Assertions.assertThat;

public class terminalStepDefinitions {
    @Given("{actor} is connected to the AS400 terminal")
    public void userConnectedToTheASTerminal(Actor actor) {
        String environment = "environments." + Serenity.environmentVariables().getProperty("environment", "default");
        actor.attemptsTo(
                InitializeTerminalSession.withDetails(
                        Serenity.environmentVariables().getProperty(environment + ".as400.host"),
                        Serenity.environmentVariables().getProperty(environment + ".as400.port"),
                        Serenity.environmentVariables().getProperty(environment + ".as400.ssl")
                )
        );
    }

    @When("{actor} log in with username {string} and password {string}")
    public void userLogInWithUsernameAndPassword(Actor actor, String username, String password) {
        actor.attemptsTo(
                LoginToTerminal.with(username, password)
        );
    }

    @And("{actor} navigate to {string}")
    public void userNavigateToGeneralSystemTasks(Actor actor, String option) {
        actor.attemptsTo(
                NavigateOnTerminal.to(option)
        );
    }

    @And("{actor} select the {string} option")
    public void userSelectTheStatusOption(Actor actor, String option) {
        actor.attemptsTo(
                NavigateOnTerminal.to(option)
        );
    }

    @And("{actor} choose the {string} option")
    public void userChooseTheDisplaySystemStatusOption(Actor actor, String option) {
        actor.attemptsTo(
                NavigateOnTerminal.to(option)
        );
    }

    @Then("{actor} should see the text {string} on the screen")
    public void userShouldSeeTheCurrentStatus(Actor actor, String searchString) {
        actor.attemptsTo(
                CheckTextFromTerminal.to(searchString)
        );
    }

    @Then("{actor} should see the text {string} or {string} on the screen")
    public void userShouldSeeTheTextOrOnTheScreen(Actor actor, String text1, String text2) {
        actor.attemptsTo(CheckTextFromTerminal.to(text1));
        boolean text1Exists = new CheckTextFromTerminal(text1).isStringExist();
        System.out.println("Text '" + text1 + "' exists on the screen: " + text1Exists);

        actor.attemptsTo(CheckTextFromTerminal.to(text2));
        boolean text2Exists = new CheckTextFromTerminal(text2).isStringExist();
        System.out.println("Text '" + text2 + "' exists on the screen: " + text2Exists);

        boolean[] textExists = {text1Exists, text2Exists};

        boolean anyTextExists = false;
        for (boolean exists : textExists) {
            if (exists) {
                anyTextExists = true;
                break;
            }
        }
        assertThat(anyTextExists).isTrue();
    }
}
