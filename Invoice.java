public class Invoice {
    private Order order;

    public Invoice(Order _order) {
        order = _order;
    }
    
    public void emailOrder(Customer buyer) {
        System.out.println(buyer.get_email() + formatOrder()); //For simplicity
    }

    private String formatOrder() {
        String str = "";
        str += String.format("Order Number: %s\n", order.get_orderNumber()); 
        str += String.format("Customer: %s\n", order.get_customerDetails().get("name")); 
        str += String.format("Address: %s\n", order.get_customerDetails().get("address")); 
        str += String.format("Order Date: %s\n", order.get_orderDate()); 
        str += formatPurchases();
        return str;
    }

    private String formatPurchases() {
        return "loop[item: price] \n total price"; //*** depends on how Item is implemented
    }

    private void updateDatabase() {
        //sends string query to Database class to store in database
    }
}
