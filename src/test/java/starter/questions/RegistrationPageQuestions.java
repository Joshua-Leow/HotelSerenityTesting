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

}
