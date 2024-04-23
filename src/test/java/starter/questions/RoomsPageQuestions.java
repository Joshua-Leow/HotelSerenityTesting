package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.pages.web.HomePage;
import starter.pages.web.RoomsPage;

public class RoomsPageQuestions {
    public static Question<Boolean> isDeluxeCardVisible() {
        return actor -> Visibility.of(RoomsPage.DELUXE_CARD)
                .answeredBy(actor);
    }

    public static Question<Boolean> isStandardCardVisible() {
        return actor -> Visibility.of(RoomsPage.STANDARD_CARD)
                .answeredBy(actor);
    }

    public static Question<Boolean> isSuperSingleCardVisible() {
        return actor -> Visibility.of(RoomsPage.SUPERSINGLE_CARD)
                .answeredBy(actor);
    }

    public static Question<Boolean> isSingleCardVisible() {
        return actor -> Visibility.of(RoomsPage.SINGLE_CARD)
                .answeredBy(actor);
    }
}
