package starter.pages.web;

import net.serenitybdd.screenplay.targets.Target;

public class AmenitiesPage {
    public static Target WIFI_CARD = Target.the("WIFI CARD").locatedBy("//h5[normalize-space()='WI-FI']");
    public static Target WALLEDTV_CARD = Target.the("WALLEDTV CARD").locatedBy("//h5[normalize-space()='WALLED-TV']");
    public static Target NEWSPAPER_CARD = Target.the("NEWSPAPER CARD").locatedBy("//h5[normalize-space()='NEWSPAPER']");
    public static Target DESKWRITING_CARD = Target.the("DESKWRITING CARD").locatedBy("//h5[normalize-space()='DESK-WRITING']");
    public static Target HOTCOFFEE_CARD = Target.the("HOTCOFFEE CARD").locatedBy("//h5[normalize-space()='HOT-COFFEE']");
    public static Target BREAKFAST_CARD = Target.the("BREAKFAST CARD").locatedBy("//h5[normalize-space()='BREAKFAST']");
    public static Target SHAMPOO_CARD = Target.the("SHAMPOO CARD").locatedBy("//h5[normalize-space()='SHAMPOO']");
    public static Target SHOWERGEL_CARD = Target.the("SHOWERGEL CARD").locatedBy("//h5[normalize-space()='SHOWER-GEL']");
    public static Target TOWELBATH_CARD = Target.the("TOWELBATH CARD").locatedBy("//h5[normalize-space()='TOWEL-BATH']");
    public static Target TOWELHAND_CARD = Target.the("TOWELHAND CARD").locatedBy("//h5[normalize-space()='TOWEL-HAND']");
    public static Target SHOWERCAP_CARD = Target.the("SHOWERCAP CARD").locatedBy("//h5[normalize-space()='SHOWER-CAP']");

}
