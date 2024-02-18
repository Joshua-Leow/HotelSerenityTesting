package starter.pages.web;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class LoginPage extends PageObject {
    public static Target USERNAME_FIELD = Target.the("User Name").locatedBy("#username");
    public static Target PASSWORD_FIELD = Target.the("User Password").locatedBy("#password");
    public static Target SIGNIN_BUTTON = Target.the("Sign In").locatedBy("//button[contains(@class, 'btn') and text()='Sign in']");
    public static Target SIGNUP_BUTTON = Target.the("Sign Up").locatedBy("//a[@type='submit' and contains(@class, 'login-button') and @href='/signup']");
}
