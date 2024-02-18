package starter.pages.web;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class HomePage extends PageObject {
    public static Target PRIMARY_ACCOUNT_VIEW_DETAILS_BUTTON = Target.the("Primary Account View Details").locatedBy("//a[@href='/account/primaryAccount' and .//div[contains(@class, 'panel-footer')]//span[contains(@class, 'pull-left') and text()='View Details']]");
}
