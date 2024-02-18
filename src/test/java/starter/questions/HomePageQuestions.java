package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.pages.web.HomePage;

public class HomePageQuestions {

    public static Question<Boolean> isPrimaryAccountViewDetailsButtonVisible() {
        return actor -> Visibility.of(HomePage.PRIMARY_ACCOUNT_VIEW_DETAILS_BUTTON)
                .answeredBy(actor);
    }
}
