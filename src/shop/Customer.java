package shop;

public class Customer extends Account {

    private String shippingAddress;

    public Customer(){}

    public Customer(String _accountName, String _email, String _phoneNo) {
        super(_accountName, _email, _phoneNo);
        setAccountType(AccountType.CUSTOMER);
    }

    public static Customer loadFromDatabse(String userID) {
        Customer acc = new Customer();

        // database stuff goes here

        return acc;
    }

    public void saveToDatabase() {
        // save details to database
    }

    public String getShippingAddress() {return shippingAddress;}
    public void setShippingAddress(String _shippingAddress) {shippingAddress = _shippingAddress;}

}
