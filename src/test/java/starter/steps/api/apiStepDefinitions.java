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
import starter.pages.API.DepositPage;
import starter.pages.API.LoginPage;

import java.util.Arrays;

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
    }

    @Then("{actor} should see the signin response authenticated successfully")
    public void userShouldSeeTheSigninResponseAuthenticatedSuccessfully(Actor actor) {
        String username = actor.recall("current_username");
        System.out.println("=======================Username: " + username);
        String expectedMessage = "Logged in successfully!";
        String expectedStatus = "success";

        SerenityRest.lastResponse().then().statusCode(200);

        JsonPath responseBody = SerenityRest.lastResponse().jsonPath();
        String token = responseBody.getString("token");
        System.out.println("=======================Token: " + token);
        String actualMessage = responseBody.getString("message");
        String actualStatus = responseBody.getString("status");

        assertThat(actualMessage).as("Message is correct").isEqualTo(expectedMessage);
        assertThat(actualStatus).as("Status is correct").isEqualTo(expectedStatus);
    }

    @When("{actor} deposit amount {string} into account {string}")
    public void userDepositAmountIntoAcount(Actor actor, String amountStr, String account) {
        Double amount = null;
        String[] validAccountTypes = {"Primary", "Savings"};

        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format. Please provide a valid number.");
            return;
        }

        if (Arrays.stream(validAccountTypes).map(String::toLowerCase).noneMatch(account.toLowerCase()::equals)) {
            String validAccountTypesMessage = String.join("', '", validAccountTypes);
            System.out.println("Invalid account type. Please provide either '" + validAccountTypesMessage + "'.");
            return;
        }

        String username = actor.recall("current_username");
        String token = actor.recall("current_token");

        DepositPage payload = new DepositPage(username, account, amount);

        Response response = SerenityRest.given()
                .baseUri(getCurrentEndpoint())
                .basePath("/deposit")
                .header("Authorization", "Bearer " + token)
                .body(payload, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post();

        Double balance = response.getBody().jsonPath().getDouble("balance");
        actor.remember("current_balance", balance);

//        String status = response.getBody().jsonPath().getString("status");
//        actor.remember("current_status", status);
    }

    @Then("{actor} should see the deposit response authenticated successfully")
    public void userShouldSeeTheDepositResponseAuthenticatedSuccessfully(Actor actor) {
        Double balance = actor.recall("current_balance");
        System.out.println("=======================Balance: " + balance);
//        String status = actor.recall("current_status");
        String expectedStatus = "success";

        SerenityRest.lastResponse().then().statusCode(200);

        // another method without using 'remember', 'recall' feature
        JsonPath responseBody = SerenityRest.lastResponse().jsonPath();
        String actualStatus = responseBody.getString("status");
        System.out.println("=======================actualStatus: " + actualStatus);

        assertThat(actualStatus).as("Status is correct").isEqualTo(expectedStatus);
    }
}