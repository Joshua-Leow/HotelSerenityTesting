package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.pages.web.HomePage;

public class HomePageQuestions {
    public static Question<Boolean> isCloudBankLogoVisible() {
        return actor -> Visibility.of(HomePage.CLOUD_BANK_LOGO)
                .answeredBy(actor);
    }

    public static Question<Boolean> isMainMenuHomeVisible() {
        return actor -> Visibility.of(HomePage.MAIN_MENU_HOME_BUTTON)
                .answeredBy(actor);
    }

    public static Question<Boolean> isMainMenuAccountsVisible() {
        return actor -> Visibility.of(HomePage.MAIN_MENU_ACCOUNTS_BUTTON)
                .answeredBy(actor);
    }

    public static Question<Boolean> isMainMenuTransferVisible() {
        return actor -> Visibility.of(HomePage.MAIN_MENU_TRANSFER_BUTTON)
                .answeredBy(actor);
    }

    public static Question<Boolean> isMainMenuAppointmentVisible() {
        return actor -> Visibility.of(HomePage.MAIN_MENU_APPOINTMENT_BUTTON)
                .answeredBy(actor);
    }

    public static Question<Boolean> isMainMenuMeVisible() {
        return actor -> Visibility.of(HomePage.MAIN_MENU_ME_BUTTON)
                .answeredBy(actor);
    }

    public static Question<Boolean> isPrimaryAccountBalanceVisible() {
        return actor -> Visibility.of(HomePage.PRIMARY_ACCOUNT_BALANCE)
                .answeredBy(actor);
    }

    public static Question<Boolean> isPrimaryAccountViewDetailsButtonVisible() {
        return actor -> Visibility.of(HomePage.PRIMARY_ACCOUNT_VIEW_DETAILS_BUTTON)
                .answeredBy(actor);
    }

    public static Question<Boolean> isSavingsAccountBalanceVisible() {
        return actor -> Visibility.of(HomePage.SAVINGS_ACCOUNT_BALANCE)
                .answeredBy(actor);
    }

    public static Question<Boolean> isSavingsAccountViewDetailsButtonVisible() {
        return actor -> Visibility.of(HomePage.SAVINGS_ACCOUNT_VIEW_DETAILS_BUTTON)
                .answeredBy(actor);
    }

    public static Question<Boolean> isGoToDepositButtonVisible() {
        return actor -> Visibility.of(HomePage.GO_TO_DEPOSIT_BUTTON)
                .answeredBy(actor);
    }

    public static Question<Boolean> isGoToWithdrawalButtonVisible() {
        return actor -> Visibility.of(HomePage.GO_TO_WITHDRAWAL_BUTTON)
                .answeredBy(actor);
    }

}
