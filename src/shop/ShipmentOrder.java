package shop;

import java.time.LocalDate;

public class ShipmentOrder {
    private Order order;
    private String status; //used for Database
    private LocalDate shipmentDate; 

    public ShipmentOrder(Order _order) {
        order = _order;
        status = "Pending";
        shipmentDate = LocalDate.now();
        updateDatabase();
    }
    
    public void sendOrder(Admin staff) {
        sendEmail(staff.getEmail());
        System.out.println("Shipment Order details sent to our staff\n"); //For simplicity
    }

    //Used for sending email (not displayed to customer)
    private String formatOrder() {
        String str = "";
        str += String.format("Order Number: %s\n", order.get_orderNumber()); 
        str += String.format("Shipping Date: %s\n", shipmentDate); 
        str += String.format("Address: %s\n", order.get_customerDetails().get("address")); 
        str += String.format("Items\n %s\n", order.get_ShoppingCart()); 
        return str;
    }

    public void setStatus(String _status) {
        if (_status == "Pending" || _status == "In Transit" || _status == "Delivered") {
            status = _status;
        }
        else {
            System.out.println("Unknown Status");
        }     
    }

    private void sendEmail(String email) {
           //sends email to staff using formatOrder()
           String order = formatOrder();
    }

    private void updateDatabase() {
        //sends string query to Database class to store in database
    }
}
