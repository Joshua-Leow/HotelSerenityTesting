package starter.pages.API;

public class BalancePage {
    private String username;


    public BalancePage(String username) {
        this.username = username;
    }

    public String getUsername() { return this.username; }

    public void setUsername(String username) {
        this.username = username;
    }
}
