package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.pages.web.HomePage;

public class HomePageQuestions {
    public static Question<Boolean> isRoomsButtonVisible() {
        return actor -> Visibility.of(HomePage.CLOUD_BANK_LOGO)
                .answeredBy(actor);
    }

    public static Question<Boolean> isAmenitiesButtonVisible() {
        return actor -> Visibility.of(HomePage.CLOUD_BANK_LOGO)
                .answeredBy(actor);
    }
}
