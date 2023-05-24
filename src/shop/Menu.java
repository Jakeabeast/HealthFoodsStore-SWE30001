package shop;

import java.util.Scanner;
import java.util.*;

public class Menu {	
	
	//Scanner instance to read user input
	public static Scanner sc = new Scanner(System.in);
	static ShoppingCart shoppingCart = new ShoppingCart();
	
	
	public static void main(String[] args) {
		ReadTxtFile file = new ReadTxtFile();
		ArrayList<Product> products = file.ReadProducts();
		Catalogue catalogue = new Catalogue(products);

		int userSelection;
		
		//Class instances
		Menu menu = new Menu();	
		ShoppingCart shopCart = new ShoppingCart();
		
		
		//Execute login 
		menu.login(); 
		//Test to validate displayShopping cart
		shopCart = menu.addItemsShoppingCart();
		
		do {			
			userSelection = menu.menuSelection(); 
			
			switch(userSelection) {
				
			case 1:
				System.out.println("1. Browse Catalogue in construction");
				break;
			case 2:					
				shoppingCart.displayCart(shopCart);
				menu.manageShoppingCart(shopCart);
				break;			
			case 3:
				/* 
				if (shopCart.isCartEmpty())
				{
					System.out.println("There are no items in cart to checkout");
					break;
				}
				else
				{
					System.out.println("[Payment assumably successful]")
					Order myOrder = new Order(customer, shopCart);  //***and chance James can add the current customer account here?
					ShipmentOrder shipment = new ShipmentOrder(myOrder, currentOrderTakingAdmin); //***any chance James can add admin account here?
					shipment.sendOrder();
					Invoice invoice = new Invoice(myOrder, customer)

					do {
						userSelection = invoiceSelection()
						if(userSelection = 1) 
						{
							invoice.emailOrder();
						}
						else if(userSelection = 2)
						{
							//continue
						}
					}
					while(userSelection != 1 || userSelection != 2);

					System.out.println("Checkout Complete\n");
				}
				*/
				System.out.println("1. Checkout in construction");
				break;
			case 4:
				System.out.println("Good Bye! Thank you for shopping with us!");
				break;
			default:
				System.out.println("Invalid option, please try again\n");
				break;
			}
		}
		while(userSelection != 4);
		sc.close();
		
	}
	
	public Menu() {}
	
	//Output menu selection and return user option selected
	public int menuSelection() {
		
		int optionSelected = 0;				
			
		System.out.println("Welcome to All Your Healthy Foods Store!");			
		System.out.println("---------------------------------------\n");
		
		System.out.println("Menu:\n ");
		System.out.println("1. Browse Catalogue");
		System.out.println("2. Display shopping cart");
		System.out.println("3. Checkout");
		System.out.println("4. Logout");
		
		System.out.print("Select an option: ");
		
		optionSelected = sc.nextInt();
		System.out.println("");
			
		return optionSelected;
	}

	public int invoiceSelection() {
		int optionSelected = 0;

		System.out.println("Would you an invoice to be sent to your email?");
		System.out.println("1. Yes");
		System.out.println("2. No");

		optionSelected = sc.nextInt();

		return optionSelected;

		
	}
	
	//Test login with user credentials
	public void login() {
		
		String userName;
		String password;
		
		System.out.println("Login to All Your Healthy Foods store!");
		System.out.println("---------------------------------------\n");
		
		System.out.print("Enter user name => ");
		userName = sc.nextLine();

		System.out.print("Enter password => ");
		password = sc.nextLine();			
		
		
		if ("user".equals(userName) && "password".equals(password)) {
	        System.out.println("User successfully logged-in\n ");
			//create customer here***
	    } else {
	        System.out.println("Invalid userName or password please try again\n");
	        login();
	    }
	}
	
	//Add items manually to shopping cart
	public ShoppingCart addItemsShoppingCart() {
		
		ShoppingCart shopCart = new ShoppingCart();
		
		// Add items to shopping cart assuming they are selected by the user from product class
        CartItem item1 = new CartItem("000001", "eggs", 4.60, 2);
        CartItem item2 = new CartItem("000002", "oat milk", 3.50, 1);
        CartItem item3 = new CartItem("000003", "multigrain bread", 5.50, 2);
        CartItem item4 = new CartItem("000004", "strawberries", 6.50, 3);
        CartItem item5 = new CartItem("000005", "somked salmon", 11.50, 1);      
        
        
        //Add items to the cart
        shopCart.addCart(item1);
        shopCart.addCart(item2);
        shopCart.addCart(item3);
        shopCart.addCart(item4);
        shopCart.addCart(item5);
        
        return shopCart;
	}	
	
    
    //Manage update and remove items from user's shopping cart 
    public void manageShoppingCart(ShoppingCart shopCart) {
		
		int optionSelected = 0;		
		int itemQuantity = 0;
		String itemSelected;
			
		System.out.println("---------------------------------------\n");
		
		System.out.println("Manage Shopping Cart:\n ");
		System.out.println("1. Update item quantity");
		System.out.println("2. Remove item");
		System.out.println("3. Go back to main menu");
		
		System.out.print("Select an option: \n");
		
		optionSelected = sc.nextInt();
		sc.nextLine();
		
		switch(optionSelected) {
		
		case 1:			
			
			System.out.print("Select the item you want to update (write name item): \n");			
			itemSelected = sc.nextLine().toLowerCase();
		
			
			System.out.print("How many items would you like?: \n");			
			itemQuantity = sc.nextInt();
			sc.nextLine();
			
			CartItem item1 = new CartItem(itemSelected, itemQuantity);			
			shopCart.updateCartQty(item1);			
			break;
		case 2:	
			
			System.out.print("Select the item you want to remove: \n");	
			itemSelected = sc.nextLine().toLowerCase();
			
			shopCart.deleteCart(itemSelected);
			break;
		case 3:					
			this.menuSelection();
			break;
		default:
			System.out.println("Invalid option, please try again\n");
			break;
			
		}		
		
		
	}    
    
	public void manageOrder(Customer customer, ShoppingCart cart)
	{

		Order order = new Order(customer, cart);

	}

}