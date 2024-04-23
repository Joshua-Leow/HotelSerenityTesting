package starter.pages.web;

import net.serenitybdd.screenplay.targets.Target;

public class RoomsPage {
    public static Target DELUXE_CARD = Target.the("Profile Dropdown Button").locatedBy("//h5[normalize-space()='deluxe Single Room']");
    public static Target STANDARD_CARD = Target.the("Profile Dropdown Button").locatedBy("//h5[normalize-space()='standard Single Room']");
    public static Target SUPERSINGLE_CARD = Target.the("Profile Dropdown Button").locatedBy("//h5[normalize-space()='super single Bed']");
    public static Target SINGLE_CARD = Target.the("Profile Dropdown Button").locatedBy("//h5[normalize-space()='single Bed']");

}
