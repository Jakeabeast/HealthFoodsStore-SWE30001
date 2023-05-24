package shop;

import classes.Category;
import classes.Product;

public class Product {

private String _productID;
private String _productName;
private Category _productCategory;
private String _productDescription;
private double _productPrice;


    public Product(String productID, String productName, Category productCategory, String productDescription, double productPrice) 
    {
        _productID = productID; //auto incremented in database
        _productName = productName;
       this._productCategory = productCategory;
        _productDescription = productDescription;
        _productPrice = productPrice;
    }

    //getters
    public String getID()
    {
        return _productID;
    }

    public String getName()
    {
        return _productName;
    }

    public Category getCategory()
    {
        return _productCategory;
    }

    public String getDescription()
    {
        return _productDescription;
    }

    public double getPrice()
    {
        return _productPrice;
    }
    
    public void printProduct()
    {
    	System.out.println( "Product ID: " + this.getID()
    						+ "\nProduct Name: " + this.getName()
    						+ "\nProductCatagory: " + this.getCategory()
    						+ "\nProductDescription: " + this.getDescription()
    						+ "\nProductPrice: " + this.getPrice()
    						+ "\n-------------------");
    }

    //-------------------Test--------------------
    
    public static void main(String[] args)
    {
    //create product items
    Product product1 = new Product("Prod00001"," 1L Whole Milk",Category.Dairy,"no reduced fat content",4.50);
    
    System.out.println("***Test product can be created\n");
    System.out.println("------------------------------------------");
    product1.printProduct();
    System.out.println("------------------------------------------");
    }
}

