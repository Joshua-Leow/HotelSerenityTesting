package starter.pages.web;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class HomePage extends PageObject {
    public static Target ABOUT_SIDE_BUTTON = Target.the("About Side Button").locatedBy("#about");
    public static Target LOGIN_SIDE_BUTTON = Target.the("Login Side Button").locatedBy("#login");
    public static Target REGISTER_SIDE_BUTTON = Target.the("Register Side Button").locatedBy("#register");
    public static Target ROOMS_BUTTON = Target.the("Rooms Button").locatedBy("#rooms");
    public static Target AMENITIES_BUTTON = Target.the("Amenities Button").locatedBy("#amenities");
}
