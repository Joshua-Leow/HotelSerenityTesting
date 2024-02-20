package starter.actions.web;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import starter.pages.web.LoginPage;
import starter.pages.web.RegistrationPage;

public class RegisterActions {


    public static Performable enterFirstName(String firstname) {
        return Task.where("{0} enters '" + firstname + "'",
                Enter.theValue(firstname).into(RegistrationPage.FIRSTNAME_FIELD)
        );
    }

    public static Performable enterLastName(String lastname) {
        return Task.where("{0} enters '" + lastname + "'",
                Enter.theValue(lastname).into(RegistrationPage.LASTNAME_FIELD)
        );
    }

    public static Performable enterPhone(String phone) {
        return Task.where("{0} enters '" + phone + "'",
                Enter.theValue(phone).into(RegistrationPage.PHONE_FIELD)
        );
    }

    public static Performable enterEmail(String email) {
        return Task.where("{0} enters '" + email + "'",
                Enter.theValue(email).into(RegistrationPage.EMAIL_FIELD)
        );
    }

    public static Performable enterUsername(String username) {
        return Task.where("{0} enters '" + username + "'",
                Enter.theValue(username).into(RegistrationPage.USERNAME_FIELD)
        );
    }

    public static Performable enterPassword(String password) {
        return Task.where("{0} enters '" + password + "'",
                Enter.theValue(password).into(RegistrationPage.PASSWORD_FIELD)
        );
    }

    public static Performable clickSignUp() {
        return Task.where("{0} clicks Sign Up button",
                Click.on(RegistrationPage.SIGNUP_BUTTON)
        );
    }
}
