package starter.actions.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class UTILITY_FUNCTIONS {

    public static void timeout(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupted status
            System.err.println("Sleep interrupted: " + e.getMessage());
        }
    }

    /**
     * Custom utiltiy function that returns the value bind to any html element (assuming there is text inside)
     * <br> Used to find the innerText value inside a html element
     *
     * @param target element to find innerText property
     * @return Question<String>> object that returns a String when an actor asks Question
     */
    public static String getElementInnerText(Target target) {
        return target.resolveFor(OnStage.theActorInTheSpotlight()).getAttribute("innerText");
//        return actor -> target.resolveFor(actor).getAttribute("innerText");
    }

    /** Custom function that returns a web element of type Target containing specific text
     * <br> Used to find html elements that can be possibly found in a webpage
     * @param innerText text inside of the html dom
     * @return Question<String>> object that returns a String when an actor asks Question
     * */
    public static Target findTargetElementWithInnerText(String innerText) {
        return Target.the("target element with : '" + innerText + "'").locatedBy("//*[normalize-space()='"+ innerText +"']");
    }

    /** Function that uses regex to get number in parentheses ()
     * <br>This function is to be used only if the string has numbers in parentheses
     * <br>E.g. (123) Records Found || (4) Records Found
     * @param text string with number inside parentheses
     * @return int value of number inside the parentheses
     * **/
    public static int findNumberInBrackets(String text) {
        // Use regular expressions to extract the number within brackets
        String regex = "\\((\\d+)\\)";
        Matcher matcher = Pattern.compile(regex).matcher(text);

        // Check if a match is found
        if (matcher.find()) {
            String numberString = matcher.group(1); // Capture the string inside brackets
            // Convert the string to an integer
            return Integer.parseInt(numberString);
        } else {
            // No number found in brackets
            throw new IllegalArgumentException("No number found in the text");
        }
    }

    /** Function that checks if strings in a List<String> are sorted in ascending order
     * <br>This function is used with findNumberInBrackets function to check if
     * <br>the strings are in ascending order
     * @param inputList List of strings (Username strings should be in the list)
     * @return boolean true if list is in ascending, false if not
     * **/
    public static boolean isSortedAlphabeticallyAscending(List<String> inputList) {
        for (int i = 0; i < inputList.size() - 1;) {
            String currentString = inputList.get(i);
            String nextString = inputList.get(i++ + 1);

            if (currentString.compareToIgnoreCase(nextString) > 0) {
                return false;
            }
        }
        return true;
    }

    /** Function that checks if strings in a List<String> are sorted in descending order
     * <br>This function is used with findNumberInBrackets function to check if
     * <br>the strings are in descending order
     * @param inputList List of strings (Username strings should be in the list)
     * @return boolean true if list is in descending, false if not
     * **/
    public static boolean isSortedAlphabeticallyDescending(List<String> inputList) {
        for (int i = 0; i < inputList.size() - 1;) {
            String currentString = inputList.get(i);
            String nextString = inputList.get(i++ + 1);

            if (currentString.compareToIgnoreCase(nextString) < 0) {
                return false;
            }
        }
        return true;
    }

    /** Function that clears a text input field by inserting CTRL + A + Del
     * @param element - the web element object you want to clear stored in a Target
     * @return Performable of the keys to simulate clearing input field
     * **/
    public static Performable clearInput(Target element) {
        return Task.where(
                Enter.keyValues(Keys.chord(Keys.CONTROL,  "a", Keys.DELETE)).into(element));
    }


    public static class WaitForSignInHeader implements Performable {
        static final Target SIGN_IN_HEADER = Target.the("sign in header")
                .locatedBy("//h2[@class='form-signin-heading']");

        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    WaitUntil.the(SIGN_IN_HEADER, isVisible()).forNoMoreThan(30).seconds()
            );
        }

        public static Performable toAppear() {
            return new WaitForSignInHeader();
        }

    }

}

