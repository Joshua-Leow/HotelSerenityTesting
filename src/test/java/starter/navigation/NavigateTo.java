package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theCheckoutPage() {
        return Task.where("{0} opens the Checkout page",
                Open.browserOn().the(CheckoutPage.class));
    }
}
