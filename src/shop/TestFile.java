package shop;

import java.util.*;

public class TestFile {
    public static void main(String args[]) {
        
        ReadTxtFile productFile = new ReadTxtFile();
        ArrayList<Product> productList = productFile.ReadProducts();
        Catalogue catalogue = new Catalogue(productList);
        System.out.println("Test Complete");

    }
}
