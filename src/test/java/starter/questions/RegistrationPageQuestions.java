package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.pages.web.RegistrationPage;

public class RegistrationPageQuestions {
    public static Question<Boolean> isEmailFieldVisible() {
        return actor -> Visibility.of(RegistrationPage.EMAIL_FIELD)
                .answeredBy(actor);
    }

    public static Question<Boolean> isPasswordFieldVisible() {
        return actor -> Visibility.of(RegistrationPage.PASSWORD_FIELD)
                .answeredBy(actor);
    }

    public static Question<Boolean> isSignUpButtonVisible() {
        return actor -> Visibility.of(RegistrationPage.SIGNUP_BUTTON)
                .answeredBy(actor);
    }

    public static Question<Boolean> isPasswordMasked() {
        return actor -> Visibility.of(RegistrationPage.PASSWORDMASKED_FIELD)
                .answeredBy(actor);
    }
}
