package starter.as400;

import org.apache.log4j.Logger;
import org.tn5250j.Session5250;
import org.tn5250j.TN5250jConstants;
import org.tn5250j.framework.common.SessionManager;
import org.tn5250j.framework.tn5250.Screen5250;
import org.tn5250j.framework.tn5250.ScreenField;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// Class to manage terminal sessions, including connecting, sending keys, and handling screen content.
@SuppressWarnings("ALL")
public class TerminalSessionManager {

    private static final Logger LOG = Logger.getLogger(TerminalSessionManager.class);
    private final Properties properties = new Properties();
    private Session5250 session;
    private volatile Screen5250 screen;
    private volatile boolean informed = false;

    // Constructor to initialize connection properties.
    public TerminalSessionManager(String host, String port, String SSLType) {
        properties.put(TN5250jConstants.SESSION_HOST, host);
        properties.put(TN5250jConstants.SESSION_HOST_PORT, port);
        properties.put(TN5250jConstants.SSL_TYPE, SSLType);
    }

    // Connects to the terminal session and initializes the screen object.
    public void connect() {
        CompletableFuture<Void> future = new CompletableFuture<>();
        if (SessionManager.instance().getSessions().getCount() == 0) {
            session = SessionManager.instance().openSession(properties, null, null);
        }
        else {
            session = SessionManager.instance().getSessions().item(0);
        }
        session.addSessionListener(changeEvent -> {
            if (changeEvent.getState() == TN5250jConstants.STATE_CONNECTED) {
                future.complete(null); // Signal completion of connection.
            }
        });
        session.connect();
        try {
            future.get();  // Wait for the connection to establish.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOG.error("Thread was interrupted during connection.", e);
        } catch (ExecutionException e) {
            LOG.error("Error occurred while connecting to the session.", e);
        }
        screen = session.getScreen();
        addOperatorInformationAreaListener();
    }

    // Adds a listener to the Operator Information Area (OIA) to track terminal state changes.
    private void addOperatorInformationAreaListener() {
        screen.getOIA().addOIAListener((oia, change) -> {
            LOG.debug(String.format("OIA %d", change));
            informed = true;
        });
    }

    // Waits until the terminal is unlocked before proceeding with further actions.
    public void waitForUnlock() {
        while (!informed) {
            try {
                Thread.sleep(100);  // Wait briefly to reduce CPU usage.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOG.warn("Interrupted while waiting for unlock.", e);
                return;
            }
        }
        dumpScreen();
        if (getLine(0).contains("Display Program Messages")) {
            sendKeys("[enter]").waitForUnlock();  // Automatically dismiss common messages.
        }
        informed = false;  // Reset for the next wait operation.
    }

    // Sends a string of keys to the terminal.
    public TerminalSessionManager sendKeys(String keys) {
        screen.sendKeys(keys);
        return this;
    }

    // Convenience method to press the Enter key.
    public void sendEnter() {
        sendKeys("[enter]").waitForUnlock();
    }

    // Logs the current screen content for debugging purposes.
    public void dumpScreen() {
        getLines().forEach(LOG::info);
    }

    // Retrieves the content of the terminal screen as a list of strings, one per row.
    public List<String> getLines() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<String> lines = new ArrayList<>(screen.getRows());
        char[] chars = screen.getCharacters();
        for (int row = 0; row < screen.getRows(); row++) {
            lines.add(new String(chars, row * screen.getColumns(), screen.getColumns()).trim());
        }
        return lines;
    }

    // Retrieves a specific line of text from the terminal screen.
    public String getLine(int row) {
        char[] chars = screen.getCharacters();
        return new String(chars, row * screen.getColumns(), screen.getColumns()).trim();
    }

    // Finds the first occurrence of the specified text on the screen and returns its index.
    public OptionalInt indexOf(String text) {
        String contents = new String(screen.getCharacters());
        int index = contents.indexOf(text);
        return index >= 0 ? OptionalInt.of(index) : OptionalInt.empty();
    }

    // Determines the line number on which the specified text appears.
    public OptionalInt lineOf(String text) {
        List<String> lines = getLines();
        for (int row = 0; row < lines.size(); row++) {
            if (lines.get(row).contains(text)) {
                return OptionalInt.of(row);
            }
        }
        return OptionalInt.empty();
    }

    // Fills the field following the specified label with the given text.
    public TerminalSessionManager fillFieldWith(String label, String text) {
        OptionalInt indexOpt = indexOf(label);
        if (indexOpt.isPresent()) {
            int index = indexOpt.getAsInt();
            ScreenField field = null;
            while (field == null && index < screen.getCharacters().length) {
                field = screen.getScreenFields().findByPosition(index++);
            }
            if (field != null) {
                field.setString(text);
                return this;
            }
        }
        throw new IllegalStateException(String.format("Could not find field after label '%s'", label));
    }

    // Sends a command by filling the command line and pressing Enter.
    public void sendCommand(String command) {
        fillFieldWith("===>", command).sendEnter();
    }

    // Retrieves the last line of a report, typically used to confirm successful completion.
    public String lastReportLine() {
        fillFieldWith("Position to line", "B").sendEnter();
        OptionalInt lineIndex = lineOf("********  End of report  ********");
        if (lineIndex.isPresent()) {
            String line = getLine(lineIndex.getAsInt());
            return line.replaceAll("[\\x00-\\x1F]", " ");  // Clean up non-printable characters.
        } else {
            throw new IllegalStateException("End of report not found");
        }
    }

    // Logs in to the terminal using the provided username and password.
    public boolean loginWithUsernameAndPassword(String username, String password) {
        fillCurrentField(username).sendKeys("[tab]");
        fillCurrentField(password).sendEnter();
        return true;  // Consider implementing a more robust login verification mechanism.
    }

    // Retrieves the name or title of the current screen.
    public String screenName() {
        return getLine(0).trim();
    }

    // Presses the Enter key a specified number of times.
    public boolean enter(int count) {
        for (int i = 0; i < count; i++) {
            sendEnter();
        }
        return true;
    }

    // Waits for a specific keypress to be processed by the terminal.
    public boolean hitWait(String key) {
        sendKeys(String.format("[%s]", key)).waitForUnlock();
        return true;
    }

    // Compiles the entire screen content into a single string.
    public String screenContents() {
        return String.join("\n", getLines());
    }

    public String getCommandNumber(String commandText) {
        // Split the screen contents into individual lines
        String[] menuLines = screenContents().split("\n");
        for (String line : menuLines) {
            if (line.toLowerCase().contains(commandText.toLowerCase().trim())) {
                // Extract the number at the beginning of the line
                String numberPart = line.split("\\.")[0].trim(); // Split by '.' and take the first part
                try {
                    return String.valueOf(Integer.parseInt(numberPart)); // Convert the number part to an integer
                } catch (NumberFormatException e) {
                    // Log error or handle it according to your error handling policy
                    System.err.println("Error parsing number from line: " + line);
                }
            }
        }
        return null; // Return null or an appropriate value if the command text is not found
    }

    // Fills the currently selected field with the specified text.
    public TerminalSessionManager fillCurrentField(String text) {
        ScreenField currentField = screen.getScreenFields().getCurrentField();
        if (currentField != null) {
            LOG.info(String.format("Filling field at cursor position: %d %d", currentField.startRow(), currentField.startCol()));
            currentField.setString(text);
            return this;
        }
        throw new IllegalStateException("No current field selected to fill");
    }

    public void terminate() {
        if (screen != null) {
            // If there's an active screen, we might need to perform some cleanup actions
            // specific to your application's logic before closing the session.
            // For example, you might want to navigate to a safe screen or log out properly.
            // This part is highly application-specific and might not be needed in all cases.

            // Example cleanup action: navigate to the main menu or log out
            // sendKeys("[pf3]"); // Assuming PF3 takes you back or logs you out
            // waitForUnlock();  // Wait for the screen to unlock after action
        }

        if (session != null && session.isConnected()) {
            session.disconnect(); // This will close the session
            session = null; // Help garbage collection by nullifying the session reference
            LOG.info("Terminal session terminated successfully.");
        } else {
            LOG.warn("No active session to terminate or the session is already disconnected.");
        }
    }
}
