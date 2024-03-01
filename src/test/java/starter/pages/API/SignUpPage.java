package starter.pages.API;

public class SignUpPage {
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;

    public SignUpPage(String username, String password, String first_name, String last_name, String email, String phone) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
    }

    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }
    public String getFirstName() { return this.first_name; }
    public String getLastName() { return this.last_name; }
    public String getEmail() { return this.email; }
    public String getPhone() { return this.phone; }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
