package starter.actions.as400;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import starter.as400.TerminalSessionManager;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginToTerminal implements Task {
    private String username;
    private String password;

    public LoginToTerminal(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Performable with(String username, String password) {
        return instrumented(LoginToTerminal.class, username, password);
    }

    @Step("{0} login #username to the terminal")
    @Override
    public <T extends Actor> void performAs(T actor) {
        TerminalSessionState sessionState = actor.recall("TERMINAL_SESSION");
        TerminalSessionManager sessionManager = sessionState.getSessionManager();
        sessionManager.fillCurrentField(username);
        sessionManager.fillFieldWith("Password", password);
        sessionManager.sendEnter();
    }
}
