package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.pages.web.HomePage;

public class HomePageQuestions {
    public static Question<Boolean> isAboutSideButtonVisible() {
        return actor -> Visibility.of(HomePage.ABOUT_SIDE_BUTTON)
                .answeredBy(actor);
    }

    public static Question<Boolean> isLoginSideButtonVisible() {
        return actor -> Visibility.of(HomePage.LOGIN_SIDE_BUTTON)
                .answeredBy(actor);
    }

    public static Question<Boolean> isRegisterSideButtonVisible() {
        return actor -> Visibility.of(HomePage.REGISTER_SIDE_BUTTON)
                .answeredBy(actor);
    }

    public static Question<Boolean> isRoomsButtonVisible() {
        return actor -> Visibility.of(HomePage.ROOMS_BUTTON)
                .answeredBy(actor);
    }

    public static Question<Boolean> isAmenitiesButtonVisible() {
        return actor -> Visibility.of(HomePage.AMENITIES_BUTTON)
                .answeredBy(actor);
    }
}
