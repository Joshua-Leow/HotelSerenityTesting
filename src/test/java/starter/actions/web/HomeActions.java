package starter.actions.web;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import starter.pages.web.HomePage;
import starter.pages.web.LoginPage;

public class HomeActions {

    public static Performable navigateToPrimaryAccountViewDetails() {
        return Task.where("{0} navigates to Primary Account View Details",
                Click.on(HomePage.PRIMARY_ACCOUNT_VIEW_DETAILS_BUTTON)
        );
    }

    public static Performable autoLogoutFromHomePage() {
        return Task.where("{0} logout",
                Click.on(HomePage.PROFILE_DROPDOWN_BUTTON),
                Click.on(HomePage.LOGOUT_BUTTON)
        );
    }

    public static Performable navigateToSavingsAccountViewDetails() {
        return Task.where("{0} navigates to Savings Account View Details",
                Click.on(HomePage.SAVINGS_ACCOUNT_VIEW_DETAILS_BUTTON)
        );
    }

    public static Performable navigateToDepositViewDetails() {
        return Task.where("{0} navigates to Savings Account View Details",
                Click.on(HomePage.GO_TO_DEPOSIT_BUTTON)
        );
    }

    public static Performable navigateToWithdrawalViewDetails() {
        return Task.where("{0} navigates to Savings Account View Details",
                Click.on(HomePage.GO_TO_WITHDRAWAL_BUTTON)
        );
    }


}
