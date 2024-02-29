package starter.pages.web;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static Target CLOUD_BANK_LOGO = Target.the("CloudBank Logo").locatedBy("//img[@alt='banner']");
    public static Target SIGNIN_LABEL = Target.the("Signin Label").locatedBy("//h2[@class='form-signin-heading']");
    public static Target USERNAME_FIELD = Target.the("User Name").locatedBy("#username");
    public static Target PASSWORD_FIELD = Target.the("User Password").locatedBy("#password");
    public static Target REMEMBER_ME_CHECKBOX = Target.the("Remember Me Checbox").locatedBy("#remember-me");
    public static Target SIGNIN_BUTTON = Target.the("Sign In").locatedBy("//button[contains(@class, 'btn') and text()='Sign in']");
    public static Target SIGNUP_BUTTON = Target.the("Sign Up").locatedBy("//a[@type='submit' and contains(@class, 'login-button') and @href='/signup']");
}
