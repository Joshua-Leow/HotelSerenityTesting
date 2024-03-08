package starter.pages.web;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class HomePage extends PageObject {
    public static Target PRIMARY_ACCOUNT_VIEW_DETAILS_BUTTON = Target.the("Primary Account View Details Button").locatedBy("//a[@href='/account/primaryAccount' and .//div[contains(@class, 'panel-footer')]//span[contains(@class, 'pull-left') and text()='View Details']]");
    public static Target PROFILE_DROPDOWN_BUTTON = Target.the("Profile Dropdown Button").locatedBy("//a[normalize-space()='Me']");
    public static Target LOGOUT_BUTTON = Target.the("Logout Button").locatedBy("//a[normalize-space()='Logout']");
//    public static Target _BUTTON = Target.the(" Button").locatedBy("");
//    public static Target _BUTTON = Target.the(" Button").locatedBy("");
//    public static Target _BUTTON = Target.the(" Button").locatedBy("");
//    public static Target _BUTTON = Target.the(" Button").locatedBy("");
//    public static Target _BUTTON = Target.the(" Button").locatedBy("");
//    public static Target _BUTTON = Target.the(" Button").locatedBy("");
//    public static Target _BUTTON = Target.the(" Button").locatedBy("");
//    public static Target _BUTTON = Target.the(" Button").locatedBy("");
//    public static Target _BUTTON = Target.the(" Button").locatedBy("");
//    public static Target _BUTTON = Target.the(" Button").locatedBy("");
//    public static Target _BUTTON = Target.the(" Button").locatedBy("");
//    public static Target _BUTTON = Target.the(" Button").locatedBy("");
//    public static Target _BUTTON = Target.the(" Button").locatedBy("");
//    public static Target _BUTTON = Target.the(" Button").locatedBy("");


}
