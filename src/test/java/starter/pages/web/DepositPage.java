package starter.pages.web;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class DepositPage extends PageObject {
    public static Target ACCOUNT_TYPE_DROPDOWN = Target.the("Account Type Dropdown").locatedBy("#accountType");
    public static Target SPECIFY_AMOUNT_TEXT = Target.the("Specify Amount Text").locatedBy("//label[contains(text(),'2. Please specify the amount you would like to dep')]");
    public static Target DEPOSIT_BUTTON = Target.the("Deposit Button").locatedBy("//button[@type='submit']");
}
