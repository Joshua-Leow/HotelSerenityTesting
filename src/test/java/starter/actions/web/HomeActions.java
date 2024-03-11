package starter.actions.web;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.pages.web.HomePage;

public class HomeActions {

    public static Performable navigateToPrimaryAccountViewDetails() {
        return Task.where("{0} navigates to Primary Account View Details",
                Click.on(HomePage.PRIMARY_ACCOUNT_VIEW_DETAILS_BUTTON)
        );
    }

    public static Performable autoLogoutFromHomePage() {
        return Task.where("{0} logout",
                Click.on(HomePage.PROFILE_DROPDOWN_BUTTON),
                Click.on(HomePage.LOGOUT_BUTTON)
        );
    }

    public static Performable navigateToSavingsAccountViewDetails() {
        return Task.where("{0} navigates to Savings Account View Details",
                Click.on(HomePage.SAVINGS_ACCOUNT_VIEW_DETAILS_BUTTON)
        );
    }

    public static Performable navigateToDepositViewDetails() {
        return Task.where("{0} navigates to Savings Account View Details",
                Click.on(HomePage.GO_TO_DEPOSIT_BUTTON)
        );
    }

    public static Performable navigateToWithdrawalViewDetails() {
        return Task.where("{0} navigates to Savings Account View Details",
                Click.on(HomePage.GO_TO_WITHDRAWAL_BUTTON)
        );
    }

    private static boolean isValidChoice(String choice, String[] validChoices) {
        for (String validChoice : validChoices) {
            if (choice.equalsIgnoreCase(validChoice)) {
                return true;
            }
        }
        return false;
    }

    public static Performable openDropdownAndNavigateToOption(String dropdown, String option) {
        String[] validDropdowns = {"Home", "Accounts", "Transfer", "Appointment", "Me"};
        String[] validOptions = {"Primary", "Savings", "Between Accounts", "To Someone Else", "Add/Edit Recipient",
                "Schedule an Appointment", "Profile", "Logout"};

        if (!isValidChoice(dropdown, validDropdowns)) {
            throw new IllegalArgumentException("Invalid dropdown choice: " + dropdown);
        }
        if (!isValidChoice(option, validOptions)) {
            throw new IllegalArgumentException("Invalid option choice: " + option);
        }

        return Task.where("{0} clicks " + dropdown + " and " + option,
                actor -> {
                    if (dropdown.equalsIgnoreCase("Home")) {
                        actor.attemptsTo(
                                Click.on(HomePage.MAIN_MENU_HOME_BUTTON)
                        );
                    }
                    else if (dropdown.equalsIgnoreCase("Accounts")) {
                        actor.attemptsTo(
                                Click.on(HomePage.MAIN_MENU_ACCOUNTS_BUTTON)
                        );
                        if (option.equalsIgnoreCase("Primary")) {
                            actor.attemptsTo(
                                    Click.on(HomePage.ACCOUNTS_PRIMARY_BUTTON)
                            );
                        } else if (option.equalsIgnoreCase("Savings")) {
                            actor.attemptsTo(
                                    Click.on(HomePage.ACCOUNTS_SAVINGS_BUTTON)
                            );
                        }
                    }
                    else if (dropdown.equalsIgnoreCase("Transfer")) {
                        actor.attemptsTo(
                                Click.on(HomePage.MAIN_MENU_TRANSFER_BUTTON)
                        );
                        if (option.equalsIgnoreCase("Between Accounts")) {
                            actor.attemptsTo(
                                    Click.on(HomePage.TRANSFER_BETWEENACCOUNTS_BUTTON)
                            );
                        } else if (option.equalsIgnoreCase("To Someone Else")) {
                            actor.attemptsTo(
                                    Click.on(HomePage.TRANSFER_TOSOMEONEELSE_BUTTON)
                            );
                        } else if (option.equalsIgnoreCase("Add/Edit Recipient")) {
                            actor.attemptsTo(
                                    Click.on(HomePage.TRANSFER_ADDEDITRECIPIENT_BUTTON)
                            );
                        }
                    }
                    else if (dropdown.equalsIgnoreCase("Appointment")) {
                        actor.attemptsTo(
                                Click.on(HomePage.MAIN_MENU_APPOINTMENT_BUTTON)
                        );
                        if (option.equalsIgnoreCase("Schedule an Appointment")) {
                            actor.attemptsTo(
                                    Click.on(HomePage.APPOINTMENT_SCHEDULE_AN_APPOINTMENT_BUTTON)
                            );
                        }
                    }
                    else if (dropdown.equalsIgnoreCase("Me")) {
                        actor.attemptsTo(
                                Click.on(HomePage.MAIN_MENU_ME_BUTTON)
                        );
                        if (option.equalsIgnoreCase("Profile")) {
                            actor.attemptsTo(
                                    Click.on(HomePage.PROFILE_BUTTON)
                            );
                        } else if (option.equalsIgnoreCase("Logout")) {
                            actor.attemptsTo(
                                    Click.on(HomePage.LOGOUT_BUTTON)
                            );
                        }
                    }
                }
        );
    }
}
