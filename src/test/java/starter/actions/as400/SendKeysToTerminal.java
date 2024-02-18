package starter.actions.as400;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import starter.as400.TerminalSessionManager;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SendKeysToTerminal implements Task {
    private String keys;

    public SendKeysToTerminal(String keys) {
        this.keys = keys;
    }

    public static Performable withKeys(String keys) {
        return instrumented(SendKeysToTerminal.class, keys);
    }

    @Step("{0} sends keys '#keys' to the terminal")
    @Override
    public <T extends Actor> void performAs(T actor) {
        TerminalSessionState sessionState = actor.recall("TERMINAL_SESSION");
        TerminalSessionManager sessionManager = sessionState.getSessionManager();
        sessionManager.sendKeys(keys);
    }
}
