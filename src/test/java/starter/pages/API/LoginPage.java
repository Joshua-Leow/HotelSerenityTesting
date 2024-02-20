package starter.pages.API;

public class LoginPage {
    private String username;
    private String password;
    private String token;


    public LoginPage(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return this.username; }
    public String getPassword() {
        return this.password;
    }
    public String getToken() { return this.token; }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setToken(String token) {
        this.token = token;
    }


}