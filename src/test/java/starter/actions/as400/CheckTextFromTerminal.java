package starter.actions.as400;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import org.junit.jupiter.api.Assertions;
import starter.as400.TerminalSessionManager;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckTextFromTerminal implements Task {
    private String searchString;

    public static boolean stringExist;

    public CheckTextFromTerminal(String option) {
        this.searchString = option;
    }

    public static Performable to(String option) {
        return instrumented(CheckTextFromTerminal.class, option);
    }

    @Step("{0} check text #searchString from Terminal")
    @Override
    public <T extends Actor> void performAs(T actor) {
        TerminalSessionState sessionState = actor.recall("TERMINAL_SESSION");
        TerminalSessionManager sessionManager = sessionState.getSessionManager();
        String output = sessionManager.screenContents().replace('\0',' ');
//        System.out.println("========== output ====================\n" + output);
//        Assertions.assertTrue(output.contains(searchString));
        stringExist = output.contains(searchString);
        sessionManager.dumpScreen();
    }

    public boolean isStringExist() {
        return stringExist;
    }
}

