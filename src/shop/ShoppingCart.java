package shop;

import java.util.ArrayList;

public class ShoppingCart {	
	
	//List holding the items user put in the Shopping Cart.
    private ArrayList<CartItem> cart;

    //Constructor to initiates the list
    public ShoppingCart() {
        cart = new ArrayList<CartItem>();
    }    
	    
    //Clears up the cart
    public void removeAllCartItems() {        
        cart = null;
    }
    
  //Get list of cart items
    public ArrayList<CartItem> getCart() {
        //returns the cart to the client
        return cart;
    }

    
    //Add items to the shopping cart list
    public boolean addCartItem(CartItem cartItem) {

        boolean result = false;

        //checks whether there is a CartItem object in the Shopping Cart 
        //having the same itemId as that of  cartItem
        try {
            if (isCartEmpty()) {

                //Add item to the cart 
               return result = cart.add(cartItem);

            } else {


                int total = 0;

                for (CartItem c : cart) {
                    //Checks if each item in the cart list has the item id
                    if (c.getItemId().equals(cartItem.getItemId())) {

                        int currentQuantity = c.getQuantity();
                        int newQuantity = cartItem.getQuantity();

                        //Sum quantity to update value
                        total = currentQuantity + newQuantity;
                        //Set new quantity
                        c.setQuantity(total);

                        return true;

                    } else {

                        //Add item to the cart if it does not exist
                        return result = cart.add(cartItem);

                    }
                }
            }
        } catch (Exception ex) {

             return result = false;
            
        }
            
        return result;

    }

    public boolean isCartEmpty()
    {
        return cart.isEmpty();
    }
	   
    //Delete an user record searched by item id
    public boolean deleteCartItem(String itemId) {

        boolean result = false;

        if (!isCartEmpty()) {
            try {
                for (CartItem c : cart) {
                    //Checks if each item in the cart list has the item name
                    if (c.getDescription().equals(itemId)) {

                        //delete item from the cart
                        cart.remove(c);

                        return result = true;
                    }
                }
            } catch (Exception ex) {

                result = false;
            }
        }
        return result;
    }

	    
    //Updates cart item information
    public boolean updateCartItem(CartItem cartItem) {

        boolean result = false;

        if (!isCartEmpty()) {
            try {

                for (CartItem c : cart) {

                    //Checks if there is an item equal to the cart Item param
                    if (c.getItemId().equals(cartItem.getItemId())) {

                        //Update values for the current cart Item
                        c.setItemId(cartItem.getItemId());
                        c.setDescription(cartItem.getDescription());
                        c.setUnitPrice(cartItem.getUnitPrice());
                        c.setQuantity(cartItem.getQuantity());

                        result = true;
                    }

                }
            } catch (Exception ex) {

                return result;
            }
        }

        return result;

    }
    
  //Updates cart item information
    public boolean updateCartItemQuantity(CartItem cartItem) {

        boolean result = false;

        if (!isCartEmpty()) {
            try {

                for (CartItem c : cart) {

                    //Checks if there is an item equal to the cart Item param
                    if (c.getDescription().equals(cartItem.getDescription())) {

                        //Update quantity for the current cart Item                        
                        c.setQuantity(cartItem.getQuantity());

                        result = true;
                    }

                }
            } catch (Exception ex) {

                return result;
            }
        }

        return result;

    }
    
  //Display shopping cart
    public void displayCart(ShoppingCart shopCart ) {
        //Cart list populated
        ArrayList<CartItem> ciList = shopCart.getCart();
        //Check if there's any item in the shopping cart
        if (ciList.isEmpty()) {
            System.out.println("The shopping cart is empty!\n");            
            return;
        }
        System.out.println("--------------------------------------");
        System.out.println("The shopping cart has the following items:");
        double total = 0.0;
        //Loop through the list to print cart items
        for (CartItem ci : ciList) {
            double unitPrice = ci.getUnitPrice();
            double quantity = ci.getQuantity();
            double subTotal = unitPrice * quantity;
            System.out.println("Item: " + ci.getDescription()
                    + "\tUnit Price: " + ci.getUnitPrice()
                    + "\tQuantity: " + ci.getQuantity()
                    + "\tSub-Total: " + subTotal);            
            total = total + subTotal;
        }
        System.out.println("--------------------------------------");
        System.out.println("Total price: " + total);
        System.out.println("---------End of Shopping Cart---------\n");
    }

  //Add item to the shopping cart 
    public void addCart(CartItem item) {
        
        //Add boolean from remote interface to check if item was added
        if (this.addCartItem(item)) {
            /*System.out.println("Your order of " + item.getQuantity()
                    + " " + item.getDescription() + " has been added.");*/
        } else {
            /*System.out.println("Sorry, your order of " + item.getQuantity() + " "
                    + item.getDescription() + " cannot be added due to low stock.\n");*/
        }
    }
    
  //Delete item from the shopping cart 
    public void deleteCart(String item) {
        System.out.println("Deletting item " + item + " from cart");
        //Add boolean from remote interface to check if item was added
        if (this.deleteCartItem(item)) {
            System.out.println("Your order of " + item + " has been deleted.");
        } else {
            System.out.println("Sorry, your order of " + item + " could not be deleted.");
        }
    }
    
    //Add item to the shopping cart 
    public void updateCart(CartItem item) {
        System.out.println("Updating item " + item.getDescription() + " to cart");
        //Add boolean from remote interface to check if item was added
        if (this.updateCartItem(item)) {
            System.out.println("Your order of " + item.getQuantity()
                    + " " + item.getDescription() + " has been updated.");
        } else {
            System.out.println("Sorry, your order of " + item.getQuantity() + " "
                    + item.getDescription() + " could not be updated.");
        }
    }
    
  //Add item to the shopping cart 
    public void updateCartQty(CartItem item) {
        System.out.println("Updating quantity of item " + item.getDescription() + " to cart");
        //Add boolean from remote interface to check if item was added
        if (this.updateCartItemQuantity(item)) {
            System.out.println("Your order of " + item.getQuantity()
                    + " " + item.getDescription() + " has been updated.");
        } else {
            System.out.println("Sorry, your order of " + item.getQuantity() + " "
                    + item.getDescription() + " could not be updated.");
        }
    }
    
    
	
    

}
