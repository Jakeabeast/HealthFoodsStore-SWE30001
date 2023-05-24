package shop;

import java.util.*;
public class Catalogue
{
    private ArrayList<Product> _products;  

    public Catalogue()
    {
        _products = new ArrayList<Product>();
    }
    
    // search for an product using the name
    public Product SearchByName(String searchName)
    {
    	for(Product p: _products)
    	{
    		if(p.getName().contains(searchName))
    				{
    					p.printProduct();
    					//return p;
    				}
    	}
    	return null; // no product found
    }
    
    //search for an product using the category type
    public Product SearchByCategory(Category searchCategory)
    {
    	for(Product p: _products)
    	{
    		if(p.getCategory()== searchCategory)
    		{
    			p.printProduct();
    			return p;
    		}
    	}
    	return null; // product not found
    }
    
    //add a product to catalogue
    public void addProduct(Product newProduct)
    {
    	_products.add(newProduct);
    }
    
  //-------------------Test--------------------
    public static void main(String[] args)
    {
  //-------------------Test Create Product--------------------
    	Catalogue storeCatalogue = new Catalogue();
    	Product product1 = new Product("Prod00001","1L Whole Milk",Category.Dairy,"no reduced fat content",4.50);
    	Product product2 = new Product("Prod00002","Strawberries pack",Category.Fruit,"packet of strawberries",5.00);
    	Product product3 = new Product("Prod00003","250ml Chocolate Milk",Category.Dairy,"250ml bottle",3.50);
    	
    	System.out.println("The following products were created:");
    	System.out.println("<-------------------------------------->");
    	product1.printProduct();
    	product2.printProduct();
    	product3.printProduct();
   //-------------------Test Add & Search Product--------------------
    	storeCatalogue.addProduct(product1);
    	storeCatalogue.addProduct(product2);
    	storeCatalogue.addProduct(product3);
   
    	System.out.println("<-------------------------------------->");
    	System.out.println("The Following are items in the Catalogue that contain the word \"milk\":");
    	
    	storeCatalogue.SearchByName("Milk");
    	
    	
    	System.out.println("<-------------------------------------->");
    	System.out.println("The Following are items in the Category Fruit:");
    	storeCatalogue.SearchByCategory(Category.Fruit);
    	
    	
    }
}
