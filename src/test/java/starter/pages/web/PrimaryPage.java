package starter.pages.web;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class PrimaryPage extends PageObject {
    public static Target PRIMARY_ACCOUNT_VIEW_DETAILS = Target.the("Primary Account View Details")
            .locatedBy("//div[@class='panel panel-info']//h2[contains(text(),'Primary Balance:')] " +
                    "| //div[@class='panel panel-info']//span[number(@text()) >= 0] " +
                    "| //div[@class='container main']//table[@id='example']//th[contains(text(),'Post Date')] " +
                    "| //div[@class='container main']//table[@id='example']//th[contains(text(),'Description')] " +
                    "| //div[@class='container main']//table[@id='example']//th[contains(text(),'Type')] " +
                    "| //div[@class='container main']//table[@id='example']//th[contains(text(),'Status')] " +
                    "| //div[@class='container main']//table[@id='example']//th[contains(text(),'Amount')] " +
                    "| //div[@class='container main']//table[@id='example']//th[contains(text(),'Available Balance')]");
}
