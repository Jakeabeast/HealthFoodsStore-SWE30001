package shop;

import java.util.ArrayList;


public class ShoppingCart {	
	
	//List holding the items user put in the Shopping Cart.

public class ShoppingCart {
	
	public static void test(String[] args) {
        
		//Change check
		//Create shopping cart instance
        ShoppingCart shopCart = new ShoppingCart();
        
        System.out.println("Welcome to All Your Healthy Foods store!\n");
        // show that the shopCart is empty
        shopCart.displayCart();
        
        
        // Add items to shopping cart assuming they are selected by the user from product class
        CartItem item1 = new CartItem("000001", "Eggs free range 12pack", 4.60, 2);
        CartItem item2 = new CartItem("000002", "Vitasoy Oat Milk ", 3.50, 1);
        CartItem item3 = new CartItem("000003", "Multigrain bread", 5.50, 2);
        CartItem item4 = new CartItem("000004", "Strawberries prepacked ", 6.50, 3);
        CartItem item5 = new CartItem("000005", "Somked salmon 100g", 11.50, 1);
        
        System.out.println("Adding selected items by user\n");
        
        //Add items to the cart
        shopCart.addCart(item1);
        shopCart.addCart(item2);
        shopCart.addCart(item3);
        shopCart.addCart(item4);
        shopCart.addCart(item5);
        
        //Display them
        shopCart.displayCart();
        

        //-------------------Test--------------------
        
        //Test it can add and sum the quantities together 
        //if the Shopping Cart does have a CartItem
        
        System.out.println("***Test it can increase item quantity already added on the cart***\n");
        CartItem item6 = new CartItem("000001", "Eggs free range 12pack", 4.60, 1);
        //Add items to the cart
        shopCart.addCart(item6);
        //Display them
        shopCart.displayCart();
        
        //If the Shopping Cart does not have a CartItem add it to the list 
        
        System.out.println("***Test it can add new items if they are not in the cart***\n");
        CartItem item7 = new CartItem("000006", "Broccolini 50g", 6.75, 2);
        //Add items to the cart
        shopCart.addCart(item7);
        //Display them
        shopCart.displayCart();     
        
        
        System.out.println("***Test it can delete item from the cart***\n");
        //Test it can delete an item from the shopping cart
        shopCart.deleteCart("000001");
        //Display them
        shopCart.displayCart();
        
        System.out.println("***Test it can update item from the cart***\n");
        //Test it can update an existing item from the shopping cart to test admin feature
        CartItem item8 = new CartItem("000002", "Vitasoy Oat Milk ", 4.50, 1);
        //Update item
        shopCart.updateCart(item8);
        //Display them
        shopCart.displayCart();
    }
	
	
	//List holding the items user put in the Shopping Cart
>>>>>>> 400dee7cea9cfa420ab52766341fc76205ccf3c5
    private ArrayList<CartItem> cart;

    //Constructor to initiates the list
    public ShoppingCart() {
        cart = new ArrayList<CartItem>();
    }    

	    
    //Get list of cart items
    public ArrayList<CartItem> getCart() {
        //returns the cart to the client
        return cart;
    }

	    
    //Clears up the cart
    public void removeAllCartItems() {        
        cart = null;
    }

    
    //Add items to the shopping cart list
    public boolean addCartItem(CartItem cartItem) {

        boolean result = false;

        //checks whether there is a CartItem object in the Shopping Cart 
        //having the same itemId as that of  cartItem
        try {
            if (cart.isEmpty()) {

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

	   
    //Delete an user record searched by item id
    public boolean deleteCartItem(String itemId) {

        boolean result = false;

        if (!cart.isEmpty()) {
            try {
                for (CartItem c : cart) {
<<<<<<< HEAD
                    //Checks if each item in the cart list has the item name
                    if (c.getDescription().equals(itemId)) {
=======
                    //Checks if each item in the cart list has the item id
                    if (c.getItemId().equals(itemId)) {
>>>>>>> 400dee7cea9cfa420ab52766341fc76205ccf3c5

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

        if (!cart.isEmpty()) {
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
    
<<<<<<< HEAD
  //Updates cart item information
    public boolean updateCartItemQuantity(CartItem cartItem) {

        boolean result = false;

        if (!cart.isEmpty()) {
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
=======
  //Display shopping cart
    public void displayCart() {
        //Cart list populated
        ArrayList<CartItem> ciList = this.getCart();
>>>>>>> 400dee7cea9cfa420ab52766341fc76205ccf3c5
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
<<<<<<< HEAD
                    + "\tSub-Total: " + subTotal);            
=======
                    + "\tSub-Total: " + subTotal);
            //Display total amount of cart
>>>>>>> 400dee7cea9cfa420ab52766341fc76205ccf3c5
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
<<<<<<< HEAD
            /*System.out.println("Your order of " + item.getQuantity()
                    + " " + item.getDescription() + " has been added.");*/
        } else {
            /*System.out.println("Sorry, your order of " + item.getQuantity() + " "
                    + item.getDescription() + " cannot be added due to low stock.\n");*/
=======
            System.out.println("Your order of " + item.getQuantity()
                    + " " + item.getDescription() + " has been added.");
        } else {
            System.out.println("Sorry, your order of " + item.getQuantity() + " "
                    + item.getDescription() + " cannot be added due to low stock.\n");
>>>>>>> 400dee7cea9cfa420ab52766341fc76205ccf3c5
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
<<<<<<< HEAD
    
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
    
    
=======
>>>>>>> 400dee7cea9cfa420ab52766341fc76205ccf3c5
	
    

}
