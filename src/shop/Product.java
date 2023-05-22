package shop;

public class Product {

private String _productID;
private String _productName;
private String _productCatagory;
private String _productDescription;
private double _productPrice;
//private int _productQuantity;


    public Product(String productID, String productName, String productCatagory, String productDescription, double productPrice) 
    {
        _productID = productID; //auto incremented in database
        _productName = productName;
        _productCatagory = productCatagory;
        _productDescription = productDescription;
        _productPrice = productPrice;
        //productQuantity = _productQuantity;
    }

    public String getID()
    {
        return _productID;
    }

    public String getName()
    {
        return _productName;
    }

    public String getCatagory()
    {
        return _productCatagory;
    }

    public String getDescription()
    {
        return _productDescription;
    }

    public double getPrice()
    {
        return _productPrice;
    }

}

