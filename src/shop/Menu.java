package shop;

import java.util.Scanner;
import java.util.*;

public class Menu {	
	
	//Scanner instance to read user input
	static Scanner sc = new Scanner(System.in);
	
	//Static class instances
	static ShoppingCart shoppingCart = new ShoppingCart();
	static Customer customer = new Customer("Jhon", "44444", "jhon@hotmail.com", "0406815854", "23 park st, St Kilda VIC 3120");
	static Admin admin = new Admin ("Carl", "554444", "carl@hotmail.com", "458454154");
	static Invoice invoice = new Invoice();
	
	
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
				menu.SearchCatalogue(catalogue);
				break;
			case 2:	
				
				shoppingCart.displayCart(shopCart);	
				menu.manageShoppingCart(shopCart);
				break;			
			case 3:				 
				menu.CheckOut(shopCart);
				
				//System.out.println("1. Checkout in construction");
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
		sc.nextLine();
		System.out.println("");
			
		return optionSelected;
	}

	//Prints out invoice and send it to customer's email
	public void requestInvoice(Order myOrder, Customer customer) {
		
		String optionSelected;

		System.out.println("Would you like an invoice to be sent to your email? (yes/no)");	
		optionSelected = sc.nextLine();

		switch(optionSelected) {
		
		case "yes":
							
			System.out.println("***********Invoice Order " + myOrder.get_orderNumber() + "**************");
			
			//Email order invoice details  to user email
			invoice.emailInvoice(customer, myOrder);			
							
			break;
			
		case "no":		
			//Return to main menu
			this.menuSelection();
			break;
			
		default:
			System.out.println("Invalid option, please try again\n");
			break;
		}

		
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
		
		//Check if password match with saved information
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
        CartItem item5 = new CartItem("000005", "smoked salmon", 11.50, 1);      
        
        
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
			
			//Create new item
			CartItem item1 = new CartItem(itemSelected, itemQuantity);
			//Update item with new quantity
			shopCart.updateCartQty(item1);			
			break;
		case 2:	
			
			System.out.print("Select the item you want to remove: \n");	
			itemSelected = sc.nextLine().toLowerCase();
			
			//Delete selected item from shopping cart list
			shopCart.deleteCart(itemSelected);
			break;
		case 3:		
			//Return to main menu
			this.menuSelection();
			break;
		default:
			System.out.println("Invalid option, please try again\n");
			break;
			
		}		
		
		
	}    
    
	
	
	public void CheckOut(ShoppingCart shopCart) {
		
		String optionSelected;
		
		//Check if cart is empty
		if (shopCart.isCartEmpty())
		{
			System.out.println("There are no items in cart to checkout\n");			
		}
		else
		{
			//Display current items on shopping cart
			shoppingCart.displayCart(shopCart);
			System.out.println("Would you like to confirm your order? (yes/no)");
			optionSelected = sc.nextLine().toLowerCase();
			
			
			switch(optionSelected) {
			
			case "yes":
								
				System.out.println("***********Payment successful**************");
				System.out.println("Your pre-saved payment details has been accepted\n");
				
				//Creates new order record with customer and shopping cart items purchased
				Order myOrder = new Order(customer, shopCart);
				System.out.println("Order confirmed Order ID: " + myOrder.get_orderNumber());
				
				//Creates new shipment record from order confirmed
				ShipmentOrder shipment = new ShipmentOrder(myOrder);
				System.out.println("\nYour order will be delivered in 2 - 3 business days!");
				
				//Send address information and notification to admin to process shipment
				shipment.sendOrder(admin);
				
				//Request invoice from confirmed order
				this.requestInvoice(myOrder, customer);				
				break;
				
			case "no":	
				//Return to main menu
				this.menuSelection();
				break;
				
			default:
				System.out.println("Invalid option, please try again\n");
				break;
			}
				
		}
		
	}
	
	public void SearchCatalogue(Catalogue shopCatalogue)
    {
    	int optionSelected = 0;
    	String searchTerm = "";
    	String searchCategory = "";
    	
    	
    	System.out.println("---------------------------------------\n");
		
		System.out.println("Manage Shopping Cart:\n ");
		System.out.println("1.Search By Name\n");
		System.out.println("2.Search By Category\n");
		System.out.println("3.Back to Main Menu\n");
		
		System.out.println("Select A Search Method: \n");
		optionSelected = sc.nextInt();
    	sc.nextLine();
    	
    	switch(optionSelected)
    	{
    	case 1:
    		System.out.println("What is the Name of the Product you want to Search: \n");
    		searchTerm = sc.nextLine();
    		shopCatalogue.SearchByName(searchTerm);
    	break;
    	
    	case 2:
    		System.out.println("What Category would you like to Search For: \n");
    		searchCategory = sc.nextLine();
    		shopCatalogue.SearchByCategory(searchCategory);
    		
    	case 3:					
			this.menuSelection();
			break;
			
		default:
			System.out.println("Invalid option, please try again\n");
			break;
    	}
    }

} //end menu class