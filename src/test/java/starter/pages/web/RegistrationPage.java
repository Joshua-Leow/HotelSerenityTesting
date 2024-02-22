package starter.pages.web;

import net.serenitybdd.screenplay.targets.Target;

public class RegistrationPage {
    public static Target FIRSTNAME_FIELD = Target.the("First Name").locatedBy("#firstName");
    public static Target LASTNAME_FIELD = Target.the("Last Name").locatedBy("#lastName");
    public static Target PHONE_FIELD = Target.the("Phone").locatedBy("#phone");
    public static Target EMAIL_FIELD = Target.the("Email").locatedBy("#email");
    public static Target USERNAME_FIELD = Target.the("Username").locatedBy("#username");
    public static Target PASSWORD_FIELD = Target.the("Password").locatedBy("#password");
    public static Target SHOWPASSWORD_CHECKBOX = Target.the("Show Password").locatedBy("#showPassword");
    public static Target SIGNUP_BUTTON = Target.the("Sign Up").locatedBy("//button[@type='submit']");
    public static Target CANCEL_BUTTON = Target.the("Cancel").locatedBy("//a[@class='btn btn-info btn-lg btn-block login-button']");

}
