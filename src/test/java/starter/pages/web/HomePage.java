package starter.pages.web;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class HomePage extends PageObject {
    public static Target PROFILE_DROPDOWN_BUTTON = Target.the("Profile Dropdown Button").locatedBy("//a[normalize-space()='Me']");
    public static Target CLOUD_BANK_LOGO = Target.the(" Cloud Bank Logo").locatedBy("//img[@alt='banner']");
    public static Target GO_TO_WITHDRAWAL_BUTTON = Target.the("Go To Withdrawal Button").locatedBy("//a[contains(@href,'/account/withdraw')]//div[contains(@class,'panel-footer')]//div[contains(@class,'clearfix')]");
}
