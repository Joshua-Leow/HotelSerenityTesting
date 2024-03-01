package starter.actions.pdf;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.pages.web.HomePage;

public class PdfActions {

    public static Performable loginWithCredentials() {
        return Task.where("{0} attempts to log in with username and password",
                Click.on(HomePage.PRIMARY_ACCOUNT_VIEW_DETAILS_BUTTON)
        );
    }
}
