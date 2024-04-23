package starter.pages.web;

import net.serenitybdd.screenplay.targets.Target;

public class RegistrationPage {
    public static Target NAME_FIELD = Target.the("Name").locatedBy("#firstName");
    public static Target EMAIL_FIELD = Target.the("Email").locatedBy("#email");
    public static Target PASSWORD_FIELD = Target.the("Password").locatedBy("#password");
    public static Target PASSWORDMASKED_FIELD = Target.the("Password Masked").locatedBy("#password[type='password']");
    public static Target REMEMBERME_CHECKBOX = Target.the("Remember Me").locatedBy("#showPassword");
    public static Target SIGNUP_BUTTON = Target.the("Sign Up").locatedBy("//button[@type='submit']");
}
