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
import starter.questions.*;

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
                seeThat(HomePageQuestions.isAboutSideButtonVisible()),
                seeThat(HomePageQuestions.isLoginSideButtonVisible()),
                seeThat(HomePageQuestions.isRegisterSideButtonVisible()),
                seeThat(HomePageQuestions.isRoomsButtonVisible()),
                seeThat(HomePageQuestions.isAmenitiesButtonVisible())
        );
    }

    @When("{actor} clicks Rooms")
    public void userClicksRooms(Actor actor) {
        actor.attemptsTo(
                HomeActions.clickRooms()
        );
    }

    @Then("{actor} should see Rooms page elements")
    public void userShouldSeeRoomsPageElements(Actor actor) {
        actor.should(
                seeThat(RoomsPageQuestions.isDeluxeCardVisible()),
                seeThat(RoomsPageQuestions.isStandardCardVisible()),
                seeThat(RoomsPageQuestions.isSuperSingleCardVisible()),
                seeThat(RoomsPageQuestions.isSingleCardVisible()),
                seeThat(HomePageQuestions.isRoomsButtonVisible()),
                seeThat(HomePageQuestions.isAmenitiesButtonVisible())
        );
    }

    @When("{actor} clicks Amenities")
    public void userClicksAmenities(Actor actor) {
        actor.attemptsTo(
                HomeActions.clickAmenities()
        );
    }

    @Then("{actor} should see Amenities page elements")
    public void userShouldSeeAmenitiesPageElements(Actor actor) {
        actor.should(
                seeThat(AmenitiesPageQuestions.isAllAmenitiesCardVisible())
        );
    }
}
