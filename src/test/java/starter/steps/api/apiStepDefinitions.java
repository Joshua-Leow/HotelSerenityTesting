package starter.steps.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import starter.actions.web.LoginActions;
import starter.pages.API.LoginPage;
import starter.questions.HomePageQuestions;

import static io.restassured.RestAssured.given;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class apiStepDefinitions {

    public String getCurrentEndpoint() {
        String environment = "environments." + Serenity.environmentVariables().getProperty("environment", "default");
        return Serenity.environmentVariables().getProperty(environment + ".restapi.baseurl");
    }

    @Given("{actor} is logged in using username {string} and password {string}")
    public void userIsLoggedInUsingUsernameUsernameAndPasswordPassword(Actor actor, String username, String password) {
        LoginPage payload = new LoginPage(username, password);
        String userName = SerenityRest.given()
                .baseUri(getCurrentEndpoint())
                .basePath("/signin")
                .body(payload, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post().getBody().as(LoginPage.class, ObjectMapperType.GSON).getUsername();
        actor.remember("current_username", userName);

        Response response = SerenityRest.given()
                .baseUri(getCurrentEndpoint())
                .basePath("/signin")
                .body(payload, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post();

        String token = response.getBody().jsonPath().getString("token");
        actor.remember("current_token", token);
    }

    @Then("{actor} should see the response authenticated successfully")
    public void userShouldSeeTheResponseAuthenticatedSuccessfully(Actor actor) {
        actor.recall("current_username");

        String token = actor.recall("current_token");
        System.out.println("Token: " + token);

        SerenityRest.lastResponse().then().statusCode(200);
    }
}