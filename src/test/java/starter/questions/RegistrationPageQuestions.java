package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.pages.web.RegistrationPage;

public class RegistrationPageQuestions {
    public static Question<Boolean> isFirstNameFieldVisible() {
        return actor -> Visibility.of(RegistrationPage.FIRSTNAME_FIELD)
                .answeredBy(actor);
    }
    public static Question<Boolean> isLastNameFieldVisible() {
        return actor -> Visibility.of(RegistrationPage.LASTNAME_FIELD)
                .answeredBy(actor);
    }
    public static Question<Boolean> isPhoneFieldVisible() {
        return actor -> Visibility.of(RegistrationPage.PHONE_FIELD)
                .answeredBy(actor);
    }
    public static Question<Boolean> isEmailFieldVisible() {
        return actor -> Visibility.of(RegistrationPage.EMAIL_FIELD)
                .answeredBy(actor);
    }
    public static Question<Boolean> isUsernameFieldVisible() {
        return actor -> Visibility.of(RegistrationPage.USERNAME_FIELD)
                .answeredBy(actor);
    }
    public static Question<Boolean> isPasswordFieldVisible() {
        return actor -> Visibility.of(RegistrationPage.PASSWORD_FIELD)
                .answeredBy(actor);
    }
    public static Question<Boolean> isShowPasswordCheckboxVisible() {
        return actor -> Visibility.of(RegistrationPage.SHOWPASSWORD_CHECKBOX)
                .answeredBy(actor);
    }
    public static Question<Boolean> isSignUpButtonVisible() {
        return actor -> Visibility.of(RegistrationPage.SIGNUP_BUTTON)
                .answeredBy(actor);
    }
    public static Question<Boolean> isCancelButtonVisible() {
        return actor -> Visibility.of(RegistrationPage.CANCEL_BUTTON)
                .answeredBy(actor);
    }

    public static Question<Boolean> isEmailExistMessageVisible() {
        return actor -> Visibility.of(RegistrationPage.EMAILEXIST_MESSAGE)
                .answeredBy(actor);
    }

    public static Question<Boolean> isUsernameExistMessageVisible() {
        return actor -> Visibility.of(RegistrationPage.USERNAMEEXIST_MESSAGE)
                .answeredBy(actor);
    }

    public static Question<Boolean> isEmailOrUsernameExistMessageVisible() {
        return actor -> Visibility.of(RegistrationPage.EMAILEXIST_MESSAGE)
                .answeredBy(actor) ||  Visibility.of(RegistrationPage.USERNAMEEXIST_MESSAGE)
                .answeredBy(actor);
    }

    public static Question<Boolean> isPasswordMasked() {
        return actor -> Visibility.of(RegistrationPage.PASSWORDMASKED_FIELD)
                .answeredBy(actor);
    }
}
