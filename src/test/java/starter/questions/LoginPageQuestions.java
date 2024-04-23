package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.pages.web.LoginPage;

public class LoginPageQuestions {
    public static Question<Boolean> isCloudBankLogoVisible() {
        return actor -> Visibility.of(LoginPage.CLOUD_BANK_LOGO)
                .answeredBy(actor);
    }

    public static Question<Boolean> isSignInLablelVisible() {
        return actor -> Visibility.of(LoginPage.SIGNIN_LABEL)
                .answeredBy(actor);
    }

    public static Question<Boolean> isUsernameFieldVisible() {
        return actor -> Visibility.of(LoginPage.EMAIL_FIELD)
                .answeredBy(actor);
    }

    public static Question<Boolean> isPasswordFieldVisible() {
        return actor -> Visibility.of(LoginPage.PASSWORD_FIELD)
                .answeredBy(actor);
    }

    public static Question<Boolean> isRememberMeCheckboxVisible() {
        return actor -> Visibility.of(LoginPage.REMEMBERME_CHECKBOX)
                .answeredBy(actor);
    }

    public static Question<Boolean> isSignInButtonVisible() {
        return actor -> Visibility.of(LoginPage.SIGNIN_BUTTON)
                .answeredBy(actor);
    }
}
