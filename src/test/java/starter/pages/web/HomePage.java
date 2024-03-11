package starter.pages.web;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class HomePage extends PageObject {
    public static Target PROFILE_DROPDOWN_BUTTON = Target.the("Profile Dropdown Button").locatedBy("//a[normalize-space()='Me']");
    public static Target CLOUD_BANK_LOGO = Target.the(" Cloud Bank Logo").locatedBy("//img[@alt='banner']");
    public static Target MAIN_MENU_HOME_BUTTON = Target.the("Main Menu Home Button").locatedBy("//a[@class='navbar-brand page-scroll']");
    public static Target MAIN_MENU_ACCOUNTS_BUTTON = Target.the("Main Menu Accounts Button").locatedBy("//a[normalize-space()='Accounts']");
    public static Target ACCOUNTS_PRIMARY_BUTTON = Target.the("Accounts Primary Button").locatedBy("//a[normalize-space()='Primary']");
    public static Target ACCOUNTS_SAVINGS_BUTTON = Target.the("Accounts Savings Button").locatedBy("//a[normalize-space()='Savings']");
    public static Target MAIN_MENU_TRANSFER_BUTTON = Target.the("Main Menu Transfer Button").locatedBy("//a[normalize-space()='Transfer']");
    public static Target TRANSFER_BETWEENACCOUNTS_BUTTON = Target.the("Transfer Between Accounts Button").locatedBy("//a[normalize-space()='Between Accounts']");
    public static Target TRANSFER_TOSOMEONEELSE_BUTTON = Target.the("Transfer To Someone Else Button").locatedBy("//a[normalize-space()='To Someone Else']");
    public static Target TRANSFER_ADDEDITRECIPIENT_BUTTON = Target.the("Transfer Add Edit Recipient Button").locatedBy("//a[normalize-space()='Add/Edit Recipient']");
    public static Target MAIN_MENU_APPOINTMENT_BUTTON = Target.the("Main Menu Appointment Button").locatedBy("//a[normalize-space()='Appointment']");
    public static Target APPOINTMENT_SCHEDULE_AN_APPOINTMENT_BUTTON = Target.the("Appointment Schedule An Appointment Button").locatedBy("//a[normalize-space()='Schedule an Appointment']");
    public static Target MAIN_MENU_ME_BUTTON = Target.the("Main Menu Me Button").locatedBy("//a[normalize-space()='Me']");
    public static Target PROFILE_BUTTON = Target.the("Profile Button").locatedBy("//a[normalize-space()='Profile']");
    public static Target LOGOUT_BUTTON = Target.the("Logout Button").locatedBy("//a[normalize-space()='Logout']");
    public static Target PRIMARY_ACCOUNT_BALANCE = Target.the("Primary Account Balance").locatedBy("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/h1[1]/span[1]");
    public static Target PRIMARY_ACCOUNT_VIEW_DETAILS_BUTTON = Target.the("Primary Account View Details Button").locatedBy("//a[@href='/account/primaryAccount' and .//div[contains(@class, 'panel-footer')]//span[contains(@class, 'pull-left') and text()='View Details']]");
    public static Target SAVINGS_ACCOUNT_BALANCE = Target.the("Savings Account Balance").locatedBy("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/h1[1]/span[1]");
    public static Target SAVINGS_ACCOUNT_VIEW_DETAILS_BUTTON = Target.the("Savings Accounts View Details Button").locatedBy("//a[@href='/account/savingsAccount']//div[@class='panel-footer']//span[@class='pull-left'][normalize-space()='View Details']");
    public static Target GO_TO_DEPOSIT_BUTTON = Target.the("Go To Deposit Button").locatedBy("//a[contains(@href,'/account/deposit')]//div[contains(@class,'panel-footer')]//div[contains(@class,'clearfix')]");
    public static Target GO_TO_WITHDRAWAL_BUTTON = Target.the("Go To Withdrawal Button").locatedBy("//a[contains(@href,'/account/withdraw')]//div[contains(@class,'panel-footer')]//div[contains(@class,'clearfix')]");
}
