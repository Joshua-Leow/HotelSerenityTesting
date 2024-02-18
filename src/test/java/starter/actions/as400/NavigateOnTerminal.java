package starter.actions.as400;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import starter.as400.TerminalSessionManager;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateOnTerminal implements Task {
    private String option;

    public NavigateOnTerminal(String option) {
        this.option = option;
    }

    public static Performable to(String option) {
        return instrumented(NavigateOnTerminal.class, option);
    }

    @Step("{0} navigate to #option")
    @Override
    public <T extends Actor> void performAs(T actor) {
        TerminalSessionState sessionState = actor.recall("TERMINAL_SESSION");
        TerminalSessionManager sessionManager = sessionState.getSessionManager();
        System.out.println(option);
        String commandNumber = sessionManager.getCommandNumber(option);
        sessionManager.fillCurrentField(commandNumber);
        sessionManager.sendEnter();
    }
}
