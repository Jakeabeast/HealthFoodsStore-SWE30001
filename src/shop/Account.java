package shop;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.json.JSONObject;
import org.mindrot.BCrypt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

enum AccountType {
    CUSTOMER(0), ADMIN(1);

    private final int value;
    private AccountType(int _value) {
        value = _value;
    }
    public int getValue() {
        return value;
    }
}

public abstract class Account {
    private String accountName;
    private String email;
    private String phoneNo;
    private String userID;
    private String passwordHash;
    private AccountType accountType;

    public Account(){}

    public Account(String _accountName, String _password, String _email, String _phoneNo) { // create a new account

        if (emailMap.containsKey(_email)) {
            throw new IllegalArgumentException(String.format("email '%s' is already in use.", _email));
        }

        accountName = _accountName;
        email = _email;
        phoneNo = _phoneNo;

        userID = UUID.randomUUID().toString();

        passwordHash = BCrypt.hashpw(_password, BCrypt.gensalt(13));

        addAccount(this);
    }

    // maps user IDs to Accounts
    private static HashMap<String, Account> accountMap = new HashMap<String, Account>();

    // maps email addresses to user IDs
    private static HashMap<String, String> emailMap = new HashMap<String, String>();

    
	 /** Get an account by its user ID
	 * @param userID	the userID to find the account by
	 * @return  the account
	 */
    public static Account getAccount(String userID) {
        Account acc = accountMap.get(userID);
        if (acc == null) {
            throw new NoSuchElementException("No account was found with ID: "+userID);
        }
        return acc;
    }

    /** Get an account by its email address
	 * @param email	the email to find the account by
	 * @return  the account
	 */
    public static Account getAccountByEmail(String email) {
        String userID = emailMap.get(email);
        if (userID == null) {
            throw new NoSuchElementException("No account was found with email: "+email);
        }
        return getAccount(userID);
    }

    /** Add an account to the database
	 * @param account	the account to add
	 */
    public static void addAccount(Account account) {
        accountMap.put(account.userID, account);
        emailMap.put(account.email, account.userID);
    }

    /** Remove an account from the database
	 * @param userID	the userID of the account to remove
	 */
    public static void deleteAccount(String userID) {
        Account acc = getAccount(userID);
        if (acc == null) {
            return;
        }
        accountMap.remove(userID);
        emailMap.remove(acc.email);
    }

    /** Load accounts into a static HashMap from a text file
	 * @param filename	the path to the accounts text file
	 */
    public static void loadAccountData(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(
            new FileReader(filename)
        );

        String line;
        while ((line = reader.readLine()) != null) {
            try {
                addAccount(decodeAccountJSON(line));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        reader.close();
    }

    /** Save account data from the static HashMap to a text file
	 * @param filename	the path to the accounts text file
	 */
    public static void saveAccountData(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(
            new FileWriter(filename)
        );

        for (Account acc : accountMap.values()) {
            writer.write(acc.toJSON().toString());
            writer.write('\n');
        }

        writer.close();
    }
    
    public String getAccountName() {return accountName;}
    public void setAccountName(String _accountName) {accountName = _accountName;}

    public String getEmail() {return email;}
    public void setEmail(String _email) {
        if (emailMap.containsKey(_email)) {
            throw new IllegalArgumentException(String.format("email '%s' is already in use.", _email));
        }

        emailMap.remove(email);
        email = _email;
        emailMap.put(email, userID);
    }

    public String getPhoneNo() {return phoneNo;}
    public void setPhoneNo(String _phoneNo) {phoneNo = _phoneNo;}

    public String getUserID() {return userID;}

    public String getPasswordHash() {return passwordHash;}

    public AccountType getAccountType() {return accountType;}
    public void setAccountType(AccountType _accountType) {accountType = _accountType;}

    /** Check the hashed password against a password attempt
	 * @param attempt	the password attempt
     * @return  true if the password is a match
	 */
    public boolean checkPassword(String attempt) {
        return BCrypt.checkpw(attempt, passwordHash);
    }

    /** Returns the account as a JSONObject with customer or admin specific fields
     * @return  a JSONObject containing account information
	 */
    public JSONObject toJSON() {
        switch (accountType) {
            case CUSTOMER:
                return ((Customer) this).toJSON();
            case ADMIN:
                return ((Admin) this).toJSON();
            default:
                return new JSONObject(); // this shouldn't happen
        }
    }

    /** Returns the account as a JSONObject
     * @return  a JSONObject containing account information
	 */
    public JSONObject getAccountJSON() {
        JSONObject json = new JSONObject();

        json.put("accountName", getAccountName());
        json.put("email", getEmail());
        json.put("phoneNo", getPhoneNo());
        json.put("userID", getUserID());
        json.put("passwordHash", getPasswordHash());
        json.put("accountType", getAccountType().getValue());

        return json;
    }

    /** Decode a JSON encoded string into an Account with Customer or Admin specific fields
     * @param encoded	the JSON encoded string
     * @return  an account object
	 */
    public static Account decodeAccountJSON(String encoded) {
        JSONObject json = new JSONObject(encoded);
        
        int accountTypeInt = json.getInt("accountType");

        Account acc;

        if (accountTypeInt == 0) {
            Customer cus = Customer.fromJSON(json);
            acc = (Account) cus;
        } else if (accountTypeInt == 1) {
            Admin adm = Admin.fromJSON(json);
            acc = (Account) adm;
        } else {
            throw new IllegalArgumentException("invalid account type: "+accountTypeInt);
        }
        
        acc.accountName = json.optString("accountName");
        acc.email = json.optString("email");
        acc.phoneNo = json.optString("phoneNo");
        acc.userID = json.optString("userID");
        acc.passwordHash = json.optString("passwordHash");

        return acc;

    }

    public static void main(String[] args) {
        System.out.println("HELLO WORLD");

        try {
            loadAccountData("Accounts.txt");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Account acc = getAccountByEmail("103641415@student.swin.edu.au");
        System.out.println(acc.checkPassword("randomguess"));
        System.out.println(acc.checkPassword("password123"));
        

        try {
            saveAccountData("Accounts.txt");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }

}