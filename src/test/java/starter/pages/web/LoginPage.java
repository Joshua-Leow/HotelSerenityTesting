package starter.pages.web;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static Target CLOUD_BANK_LOGO = Target.the("CloudBank Logo").locatedBy("//img[@alt='banner']");
    public static Target SIGNIN_LABEL = Target.the("Signin Label").locatedBy("//h2[@class='form-signin-heading']");
    public static Target EMAIL_FIELD = Target.the("Email").locatedBy("#username");
    public static Target PASSWORD_FIELD = Target.the("User Password").locatedBy("#password");
    public static Target REMEMBERME_CHECKBOX = Target.the("Remember Me Checbox").locatedBy("#remember-me");
    public static Target SIGNIN_BUTTON = Target.the("Sign In").locatedBy("//button[contains(@class, 'btn') and text()='Sign in']");
}
