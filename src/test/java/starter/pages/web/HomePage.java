package starter.pages.web;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class HomePage extends PageObject {
    public static Target ABOUT_SIDE_BUTTON = Target.the("Profile Dropdown Button").locatedBy("//a[normalize-space()='Me']");
    public static Target LOGIN_SIDE_BUTTON = Target.the(" Cloud Bank Logo").locatedBy("//img[@alt='banner']");
    public static Target REGISTER_SIDE_BUTTON = Target.the("Go To Withdrawal Button").locatedBy("//a[contains(@href,'/account/withdraw')]//div[contains(@class,'panel-footer')]//div[contains(@class,'clearfix')]");
    public static Target ROOMS_BUTTON = Target.the("Go To Withdrawal Button").locatedBy("//a[contains(@href,'/account/withdraw')]//div[contains(@class,'panel-footer')]//div[contains(@class,'clearfix')]");
    public static Target AMENITIES_BUTTON = Target.the("Go To Withdrawal Button").locatedBy("//a[contains(@href,'/account/withdraw')]//div[contains(@class,'panel-footer')]//div[contains(@class,'clearfix')]");
}
