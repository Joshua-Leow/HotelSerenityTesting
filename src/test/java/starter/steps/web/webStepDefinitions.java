package starter.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;
import starter.actions.web.HomeActions;
import starter.actions.web.LoginActions;
import starter.actions.web.RegisterActions;
import starter.actions.web.UTILITY_FUNCTIONS;
import starter.pages.web.LoginPage;
import starter.questions.HomePageQuestions;
import starter.questions.LoginPageQuestions;
import starter.questions.RegistrationPageQuestions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.anyOf;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static starter.steps.database.databaseStepDefinitions.checkUserExists;

public class webStepDefinitions {
    @Given("{actor} is on the landing page")
    public void userIsOnTheLandingPage(Actor actor) {
        actor.attemptsTo(
                LoginActions.navigateToLoginPage()
        );
    }

    @Then("{actor} should see Dashboard page elements")
    public void userShouldSeeDashboardPageElements(Actor actor) {
        actor.should(
                seeThat(HomePageQuestions.isRoomsButtonVisible()),
                seeThat(HomePageQuestions.isAmenitiesButtonVisible())
        );
    }
}
