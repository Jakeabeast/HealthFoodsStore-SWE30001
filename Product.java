public class Product {

    private int _productID;
    private String _productName;
    private String _productCatagory;
    private double _productPrice;
    private int _productQuantity;
    
    
        public Product(int productID,String productName, String productCatagory, double productPrice,int productQuantity) 
        {
            productID =_productID; //auto incremented in database
            productName = _productName;
            productCatagory =_productCatagory;
            productPrice = _productPrice;
            productQuantity = _productQuantity;
        }
    
        public String getName()
        {
            return _productName;
        }
    
        public String getCatagory()
        {
            return _productCatagory;
        }
    
        public double getPrice()
        {
            return _productPrice;
        }
    
    }
    