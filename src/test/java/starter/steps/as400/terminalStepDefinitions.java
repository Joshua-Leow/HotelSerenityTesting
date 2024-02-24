package starter.steps.as400;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import starter.actions.as400.*;

public class terminalStepDefinitions {
    @Given("{actor} is connected to the AS400 terminal")
    public void userConnectedToTheASTerminal(Actor actor) {
        String environment = "environments." + Serenity.environmentVariables().getProperty("environment", "default");
        // Check if there is an existing session and terminate it
        if (actor.recall("TERMINAL_SESSION") != null) {
            TerminalSessionState existingSession = actor.recall("TERMINAL_SESSION");
            existingSession.getSessionManager().terminate(); // Ensure this method exists and properly terminates the session
            actor.forget("TERMINAL_SESSION"); // Forget the existing session state
        }
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
}
