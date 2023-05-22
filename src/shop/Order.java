package shop;

import java.time.LocalDate;
import java.util.*;

public class Order {

    private int orderNumber;
    private String orderStatus; //used for Database
    private LocalDate orderDate;
    private Map<String, String> customerDetails = new HashMap<String, String>();
    private ArrayList<CartItem> productList;

    public Order(Customer customer, ShoppingCart cart)
    {
        orderNumber = 1; //check database, increment from history of order in database
        orderStatus = "Order placed"; //Assuming payment worked
        orderDate = LocalDate.now();
        customerDetails.put("name", customer.getAccountName());
        customerDetails.put("address", customer.getShippingAddress());
        productList = cart.getCart(); //*** get item from cart function
    }

    public int get_orderNumber() { return orderNumber; }
    public LocalDate get_orderDate() { return orderDate; }
    public Map<String, String> get_customerDetails() { return customerDetails; }
    public ArrayList<CartItem> get_productList() { return productList; }

    public void completeOrder() {
        orderStatus = "Order Complete";
        updateDatabase();
    }
    
    public ShipmentOrder generateShipmentOrder()
    {
        ShipmentOrder shipmentOrder = new ShipmentOrder(this);
        return shipmentOrder;
    }

    public Invoice generateInvoice()
    {
        Invoice invoice = new Invoice(this);
        return invoice;
    }
    
    private void updateDatabase() {
        //sends string query to Database class to store in database
    }
}
