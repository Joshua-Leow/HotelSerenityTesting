package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.pages.web.PrimaryPage;

public class PrimaryPageQuestions {

    public static Question<Boolean> isPrimaryAccountViewDetailsVisible() {
        return actor -> Visibility.of(PrimaryPage.PRIMARY_ACCOUNT_VIEW_DETAILS)
                .answeredBy(actor);
    }
}
