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


    public static Performable enterName(String name) {
        return Task.where("{0} enters '" + name + "'",
                Enter.theValue(name).into(RegistrationPage.NAME_FIELD)
        );
    }

    public static Performable enterEmail(String email) {
        return Task.where("{0} enters '" + email + "'",
                Enter.theValue(email).into(RegistrationPage.EMAIL_FIELD)
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
