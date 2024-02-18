package starter.actions.as400;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InitializeTerminalSession implements Task {
    private String host;
    private String port;
    private String SSLType;

    public InitializeTerminalSession(String host, String port, String SSLType) {
        this.host = host;
        this.port = port;
        this.SSLType = SSLType;
    }

    public static Performable withDetails(String host, String port, String SSLType) {
        return instrumented(InitializeTerminalSession.class, host, port, SSLType);
    }

    @Step("{0} initializes the terminal session")
    @Override
    public <T extends Actor> void performAs(T actor) {
        TerminalSessionState sessionState = new TerminalSessionState(host, port, SSLType);
        sessionState.getSessionManager().connect();
        actor.remember("TERMINAL_SESSION", sessionState);
    }
}
