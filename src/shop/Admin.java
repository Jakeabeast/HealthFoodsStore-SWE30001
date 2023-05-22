package shop;

public class Admin extends Account {

    public Admin(){}

    public Admin(String _accountName, String _email, String _phoneNo) {
        super(_accountName, _email, _phoneNo);
        setAccountType(AccountType.ADMIN);
    }

    public static Admin loadFromDatabse(String userID) {
        Admin acc = new Admin();

        // database stuff goes here

        return acc;
    }

    public void saveToDatabase() {
        // save details to database
    }
}