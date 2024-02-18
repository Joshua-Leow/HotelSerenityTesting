package starter.actions.web;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import starter.pages.web.LoginPage;

public class LoginActions {

    public static Performable navigateToLoginPage() {
        return Task.where("{0} navigates to login page",
                Open.browserOn().the(LoginPage.class)
        );
    }
    public static Performable enterUserName(String username) {
        return Task.where("{0} enters username '" + username + "'",
                Enter.theValue(username).into(LoginPage.USERNAME_FIELD)
        );
    }

    public static Performable enterUserPassword(String password) {
        return Task.where("{0} enters password '" + password + "'",
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD)
        );
    }

    public static Performable clickSignIn() {
        return Task.where("{0} clicks Sign In button",
                Click.on(LoginPage.SIGNIN_BUTTON)
        );
    }
}
