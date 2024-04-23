package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.pages.web.AmenitiesPage;
import starter.pages.web.RoomsPage;

public class AmenitiesPageQuestions {
    public static Question<Boolean> isAllAmenitiesCardVisible() {
        return actor -> {
            boolean isWiFiVisible = Visibility.of(AmenitiesPage.DELUXE_CARD).answeredBy(actor);
            boolean isWalledTVVisible = Visibility.of(AmenitiesPage.DELUXE_CARD).answeredBy(actor);
            boolean isNewspaperVisible = Visibility.of(AmenitiesPage.DELUXE_CARD).answeredBy(actor);
            boolean isDeskVisible = Visibility.of(AmenitiesPage.DELUXE_CARD).answeredBy(actor);
            boolean isCoffeeVisible = Visibility.of(AmenitiesPage.DELUXE_CARD).answeredBy(actor);
            boolean isBreakfastVisible = Visibility.of(AmenitiesPage.DELUXE_CARD).answeredBy(actor);
            boolean isShampooVisible = Visibility.of(AmenitiesPage.DELUXE_CARD).answeredBy(actor);
            boolean isShowerGelVisible = Visibility.of(AmenitiesPage.DELUXE_CARD).answeredBy(actor);
            boolean isTowelBathVisible = Visibility.of(AmenitiesPage.DELUXE_CARD).answeredBy(actor);
            boolean isTowelHandVisible = Visibility.of(AmenitiesPage.DELUXE_CARD).answeredBy(actor);
            boolean isShowerCapVisible = Visibility.of(AmenitiesPage.DELUXE_CARD).answeredBy(actor);

            return isWiFiVisible && isWalledTVVisible && isNewspaperVisible && isDeskVisible && isCoffeeVisible && isBreakfastVisible && isShampooVisible && isShowerGelVisible && isTowelBathVisible && isTowelHandVisible && isShowerCapVisible;
        };
    }

}
