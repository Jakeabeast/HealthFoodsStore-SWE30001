package shop;

import org.json.JSONObject;

public class Customer extends Account {

    private String shippingAddress;

    public Customer(){}

    public Customer(String _accountName, String _password, String _email, String _phoneNo, String _address)  {
        super(_accountName, _password, _email, _phoneNo);
        setAccountType(AccountType.CUSTOMER);
        setShippingAddress(_address);
    }

    /**
	 * Get a JSONObject of the Customer data
	 * @return	JSONObject containing customer and account data
	 */
    public JSONObject toJSON() {
        JSONObject json = super.getAccountJSON();

        json.put("shippingAddress", shippingAddress);

        return json;
    }

    /**
	 * Get a new Customer object containing customer specific data
     * @param	json a JSONObject containing customer data
	 * @return	a Customer object
	 */
    public static Customer fromJSON(JSONObject json) {
        Customer cus = new Customer();
        cus.setAccountType(AccountType.CUSTOMER);
        cus.setShippingAddress(json.optString("shippingAddress"));
        return cus;
    }

    public String getShippingAddress() {return shippingAddress;}
    public void setShippingAddress(String _shippingAddress) {shippingAddress = _shippingAddress;}

}
