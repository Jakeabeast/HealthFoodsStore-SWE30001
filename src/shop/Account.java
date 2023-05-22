package shop;

import java.util.UUID;

enum AccountType {
    CUSTOMER,
    ADMIN;
}

public abstract class Account {
    private String accountName;
    private String email;
    private String phoneNo;
    private String userID;
    private AccountType accountType;

    // unsure about account status

    public Account(){}

    public Account(String _accountName, String _email, String _phoneNo) { // create a new account
        accountName = _accountName;
        email = _email;
        phoneNo = _phoneNo;

        userID = UUID.randomUUID().toString();
    }
    
    public String getAccountName() {return accountName;}
    public void setAccountName(String _accountName) {accountName = _accountName;}

    public String getEmail() {return email;}
    public void setEmail(String _email) {email = _email;}

    public String getPhoneNo() {return phoneNo;}
    public void setPhoneNo(String _phoneNo) {phoneNo = _phoneNo;}

    public String getUserID() {return userID;}

    public AccountType getAccountType() {return accountType;}
    public void setAccountType(AccountType _accountType) {accountType = _accountType;}

    public boolean checkPassword(String attempt) {
        // get password hash from database using userID
        // check attempt against hash
        return false;
    }

}