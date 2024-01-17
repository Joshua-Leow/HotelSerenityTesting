package starter.fill;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.Keys;

public class EnterCheckoutDetails {

    public static Performable enterFirstName(String firstName) {
        return Task.where("{0} enters first name '" + firstName + "'",
                Enter.theValue(firstName).into(CheckoutForm.FIRSTNAME_FIELD),
                Hit.the(Keys.ENTER).into(CheckoutForm.FIRSTNAME_FIELD)
        );
    }

    public static Performable enterLastName(String lastName) {
        return Task.where("{0} enters last name '" + lastName + "'",
                Enter.theValue(lastName).into(CheckoutForm.LASTNAME_FIELD),
                Hit.the(Keys.ENTER).into(CheckoutForm.LASTNAME_FIELD)
        );
    }

    public static Performable enterEmail(String email) {
        return Task.where("{0} enters email '" + email + "'",
                Enter.theValue(email).into(CheckoutForm.EMAIL_FIELD),
                Hit.the(Keys.ENTER).into(CheckoutForm.EMAIL_FIELD)
        );
    }

    public static Performable enterAddress(String address) {
        return Task.where("{0} enters address '" + address + "'",
                Enter.theValue(address).into(CheckoutForm.ADDRESS_FIELD),
                Hit.the(Keys.ENTER).into(CheckoutForm.ADDRESS_FIELD)
        );
    }

    public static Performable selectCountry(String country) {
        return Task.where("{0} selects country '" + country + "'",
                SelectFromOptions.byVisibleText(country).from(CheckoutForm.COUNTRY_DROPDOWN)
        );
    }

    public static Performable enterZipCode(String zipCode) {
        return Task.where("{0} enters zip code '" + zipCode + "'",
                Enter.theValue(zipCode).into(CheckoutForm.ZIP_FIELD),
                Hit.the(Keys.ENTER).into(CheckoutForm.ZIP_FIELD)
        );
    }

    public static Performable selectPaymentMethod(String paymentMethod) {
        System.out.println("paymentMethod: " + paymentMethod);
        if (paymentMethod.toLowerCase().contains("credit")) {
            return Task.where("{0} selects payment method 'credit'",
                    Click.on(CheckoutForm.CREDIT_CARD_RADIO)
            );
        }
        else {
            return Task.where("{0} selects payment method 'debit'",
                    Click.on(CheckoutForm.CREDIT_CARD_RADIO)
            );
        }
    }

    public static Performable clickSubmitButton() {
        return Task.where("{0} clicks the Submit button",
                Click.on(CheckoutForm.SUBMIT_BUTTON)
        );
    }
}
