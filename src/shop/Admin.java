package shop;

import org.json.JSONObject;

public class Admin extends Account {

    public Admin(){}

    public Admin(String _accountName, String _password, String _email, String _phoneNo) {
        super(_accountName, _password, _email, _phoneNo);
        setAccountType(AccountType.ADMIN);
    }

    /**
	 * Get a JSONObject of the Admin data
	 * @return	JSONObject containing account data
	 */
    public JSONObject toJSON() {
        return super.getAccountJSON();
    }

    /**
	 * Get a new Admin object with the ADMIN AccountType
     * @param	json a JSONObject containing account data
	 * @return	an Admin object
	 */
    public static Admin fromJSON(JSONObject json) {
        Admin adm = new Admin();
        adm.setAccountType(AccountType.ADMIN);
        return adm;
    }
}