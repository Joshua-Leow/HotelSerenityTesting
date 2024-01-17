package starter.fill;

import net.serenitybdd.screenplay.targets.Target;

class CheckoutForm {
    static Target FIRSTNAME_FIELD = Target.the("first name").locatedBy("#firstName");
    static Target LASTNAME_FIELD = Target.the("last name").locatedBy("#lastName");
    static Target EMAIL_FIELD = Target.the("email").locatedBy("#email");
    static Target ADDRESS_FIELD = Target.the("address").locatedBy("#address2");
    static Target COUNTRY_DROPDOWN = Target.the("country dropdown").locatedBy("#country");
    static Target ZIP_FIELD = Target.the("zip code").locatedBy("#zip");
    static Target CREDIT_CARD_RADIO = Target.the("credit card radio").locatedBy("#credit");
    static Target SUBMIT_BUTTON = Target.the("submit button").locatedBy("/html/body/div[2]/main/div[2]/div[2]/form/button");
}
