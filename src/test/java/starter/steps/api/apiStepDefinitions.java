package starter.steps.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import starter.pages.API.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;


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
        String userName = payload.getUsername();
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

        String message = response.getBody().jsonPath().getString("message");
        actor.remember("current_message", message);

        String status = response.getBody().jsonPath().getString("status");
        actor.remember("current_status", status);
    }

    @Then("{actor} should see the signin response authenticated successfully")
    public void userShouldSeeTheSigninResponseAuthenticatedSuccessfully(Actor actor) {
        String username = actor.recall("current_username");
        System.out.println("=======================Username: " + username);
        String token = actor.recall("current_token");
        System.out.println("=======================Token: " + token);
        String expectedMessage = "Logged in successfully!";
        String expectedStatus = "success";

        SerenityRest.lastResponse().then().statusCode(200);

        JsonPath responseBody = SerenityRest.lastResponse().jsonPath();
        String actualMessage = responseBody.getString("message");
        String actualStatus = responseBody.getString("status");

        assertThat(actualMessage).as("Message is correct").isEqualTo(expectedMessage);
        assertThat(actualStatus).as("Status is correct").isEqualTo(expectedStatus);
    }

    @When("{actor} deposit amount {double} into account {string}")
    public void userDepositAmountIntoAcount(Actor actor, Double amount, String account) {

    }
}