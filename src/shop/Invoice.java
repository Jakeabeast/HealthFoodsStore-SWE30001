package shop;

public class Invoice {
    private Order order;

    public Invoice() { 
    	
    	order = new Order();
    }
    
    public Invoice(Order _order) {
        order = _order;
        updateDatabase();
    }
    
    public void emailInvoice(Customer buyer, Order order) {
        sendEmail(buyer.getEmail());
        formatInvoice(order);
        System.out.println("Invoice sent to: " + buyer.getEmail() + "\n"); //For simplicity
    }

    private void formatInvoice(Order order) {
    	
    	System.out.println("Order Number: " +  order.get_orderNumber() + "\n"); 
    	System.out.println("Order Date: " + order.get_orderDate() + "\n"); 
    	System.out.println("Customer: " + order.get_customerDetails().get("name") + "\n"); 
    	System.out.println("Address: " + order.get_customerDetails().get("address") + "\n");    	
    	order.displayOrderDetails(order);
        
    }

    private void sendEmail(String email) {
        //sends email to customer using formatOrder()
    }
    private void updateDatabase() {
        //sends string query to Database class to store in database
    }
}
