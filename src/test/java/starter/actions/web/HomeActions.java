package starter.actions.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.pages.web.HomePage;

public class HomeActions {

    public static Performable clickRooms() {
        return Task.where("{0} clicks Rooms button",
                Click.on(HomePage.ROOMS_BUTTON)
        );
    }

    public static Performable clickAmenities() {
        return Task.where("{0} clicks Rooms button",
                Click.on(HomePage.AMENITIES_BUTTON)
        );
    }
}
