package shop;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*; 

public class ReadTxtFile {

    public ReadTxtFile() {}

    public ArrayList<Product> ReadProducts() {
        
        ArrayList<Product> catalogue = new ArrayList<Product>();
        
        try {
            //File productsFileObj = new File("Products.txt");
        
            Scanner fileReader = new Scanner(new File("Products.txt"));
            fileReader.useDelimiter("-|\n");
            while (fileReader.hasNextLine()) {

                String productID = fileReader.next();
                String productName = fileReader.next();
                String productCatagory = fileReader.next();
                String productDescription = fileReader.next();
                double productPrice = Double.valueOf(fileReader.next().substring(1));                

                Product item = new Product(productID, productName, productCatagory, productDescription, productPrice);
                catalogue.add(item);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return catalogue;
    }
}
