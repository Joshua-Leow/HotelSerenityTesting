package starter.steps.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.remote.DesiredCapabilities;
import starter.actions.web.LoginActions;

import java.net.MalformedURLException;
import java.net.URL;

public class mobileStepDefinitions {

    @Given("{actor} is on the login page using mobile")
    public AndroidDriver userIsOnTheLoginPageUsingMobile(Actor actor) {
        AndroidDriver mdriver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("fullReset", "true");
        capabilities.setCapability("appPackage", "com.example.dummybank");
        capabilities.setCapability("appActivity", "com.example.dummybank.MainActivity");
        capabilities.setCapability("app", "C:\\test-automation\\gientech-training-test-automation-e2e-01\\src\\test\\resources\\packages\\dummy-bank.apk");
        try {
            mdriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return mdriver;
    }

    @Given("{actor} is on the login page via mobile")
    public void userIsOnTheLoginPage(Actor actor) {
        actor.attemptsTo(
                LoginActions.navigateToLoginPage()
        );
    }

    @When("{actor} input username {string} and password {string} using mobile")
    public void userInputUsernameUsernameAndPasswordPasswordUsingMobile(Actor actor, String username, String password) {

    }
}
