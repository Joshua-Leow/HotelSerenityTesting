package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.pages.web.AmenitiesPage;
import starter.pages.web.RoomsPage;

public class AmenitiesPageQuestions {
    public static Question<Boolean> isAllAmenitiesCardVisible() {
        return actor -> {
            boolean isWiFiVisible = Visibility.of(AmenitiesPage.WIFI_CARD).answeredBy(actor);
            boolean isWalledTVVisible = Visibility.of(AmenitiesPage.WALLEDTV_CARD).answeredBy(actor);
            boolean isNewspaperVisible = Visibility.of(AmenitiesPage.NEWSPAPER_CARD).answeredBy(actor);
            boolean isDeskVisible = Visibility.of(AmenitiesPage.DESKWRITING_CARD).answeredBy(actor);
            boolean isCoffeeVisible = Visibility.of(AmenitiesPage.HOTCOFFEE_CARD).answeredBy(actor);
            boolean isBreakfastVisible = Visibility.of(AmenitiesPage.BREAKFAST_CARD).answeredBy(actor);
            boolean isShampooVisible = Visibility.of(AmenitiesPage.SHAMPOO_CARD).answeredBy(actor);
            boolean isShowerGelVisible = Visibility.of(AmenitiesPage.SHOWERGEL_CARD).answeredBy(actor);
            boolean isTowelBathVisible = Visibility.of(AmenitiesPage.TOWELBATH_CARD).answeredBy(actor);
            boolean isTowelHandVisible = Visibility.of(AmenitiesPage.TOWELHAND_CARD).answeredBy(actor);
            boolean isShowerCapVisible = Visibility.of(AmenitiesPage.SHOWERCAP_CARD).answeredBy(actor);

            return isWiFiVisible && isWalledTVVisible && isNewspaperVisible && isDeskVisible && isCoffeeVisible && isBreakfastVisible && isShampooVisible && isShowerGelVisible && isTowelBathVisible && isTowelHandVisible && isShowerCapVisible;
        };
    }

}
