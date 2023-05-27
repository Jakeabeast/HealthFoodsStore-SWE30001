package shop;

public class CartItem {
	private String itemId;
    private String description;
    private double unitPrice;
    private int quantity;

    //Constructor.
    public CartItem(String _itemId, String _description, double _unitPrice, int _qty) {
        itemId = _itemId;
        description = _description;
        unitPrice = _unitPrice;
        quantity = _qty;
    }
    
    //Constructor 2 to update product quantity
    public CartItem(String desc,  int qty) {        
        description = desc;        
        quantity = qty;
    }
    
    public CartItem() {        
        
    }
    

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
