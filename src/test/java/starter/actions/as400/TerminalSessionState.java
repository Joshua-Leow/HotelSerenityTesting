package starter.actions.as400;

import starter.as400.TerminalSessionManager;

public class TerminalSessionState {
    private TerminalSessionManager sessionManager;

    public TerminalSessionState(String host, String port, String SSLType) {
        sessionManager = new TerminalSessionManager(host, port, SSLType);
    }

    public TerminalSessionManager getSessionManager() {
        return sessionManager;
    }

}
