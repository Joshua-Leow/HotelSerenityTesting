package starter.pages.API;

public class DepositPage {
    private String username;
    private String account_type;
    private Double amount;

    public DepositPage(String username, String account, Double amount) {
        this.username = username;
        this.account_type = account;
        this.amount = amount;
    }

    public String getUsername() { return this.username; }
    public String getAccountType() {
        return this.account_type;
    }
    public Double getAmount() { return this.amount; }


    public void setUsername(String username) {
        this.username = username;
    }
    public void setAccountType(String password) {
        this.account_type = account_type;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
