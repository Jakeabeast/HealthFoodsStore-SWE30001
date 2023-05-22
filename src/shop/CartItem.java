package shop;

public class CartItem {
	private String itemId;
    private String description;
    private double unitPrice;
    private int quantity;

<<<<<<< HEAD
    //Constructor.
=======
    //Constructor
    public CartItem(Product product, int qty) {
        itemId = product.getID();
        description = product.getDescription();
        unitPrice = product.getPrice();
        quantity = qty;
    }

>>>>>>> 400dee7cea9cfa420ab52766341fc76205ccf3c5
    public CartItem(String _itemId, String _description, double _unitPrice, int _qty) {
        itemId = _itemId;
        description = _description;
        unitPrice = _unitPrice;
        quantity = _qty;
    }
<<<<<<< HEAD
    
    //Constructor 2 to update product quantity
    public CartItem(String desc,  int qty) {        
        description = desc;        
        quantity = qty;
    }
    
=======
>>>>>>> 400dee7cea9cfa420ab52766341fc76205ccf3c5

    public String getItemId() {
        return itemId;
    }

    public String getDescription() {
        return description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }	

}
