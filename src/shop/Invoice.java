package shop;

public class Invoice {
    private Order order;

    public Invoice(Order _order) {
        order = _order;
        updateDatabase();
    }
    
    public void emailOrder(Customer buyer) {
        sendEmail(buyer.getEmail());
        System.out.println(formatOrder() + "Order sent to: " + buyer.getEmail()); //For simplicity
    }

    private String formatOrder() {
        String str = "-------------------------\n";
        str += String.format("Order Number: %s\n", order.get_orderNumber()); 
        str += String.format("Customer: %s\n", order.get_customerDetails().get("name")); 
        str += String.format("Address: %s\n", order.get_customerDetails().get("address")); 
        str += String.format("Order Date: %s\n\n", order.get_orderDate()); 
        str += order.get_ShoppingCart().displayCart();
        return str;
    }

    private void sendEmail(String email) {
        //sends email to customer using formatOrder()
    }
    private void updateDatabase() {
        //sends string query to Database class to store in database
    }
}
