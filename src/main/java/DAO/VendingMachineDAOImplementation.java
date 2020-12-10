/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author W
 */
public class VendingMachineDAOImplementation implements VendingMachineDAOInterface{
    HashMap<Integer, Product> products = new HashMap<>();    
    public final String PRODUCT_RECORD;
    
    public static final String DELIMITER = "::";   

    public VendingMachineDAOImplementation() throws CannotOpenFile {
        PRODUCT_RECORD = "product_file.txt";        
        loadProducts();
    }

    public VendingMachineDAOImplementation(String product_file) {
        PRODUCT_RECORD = product_file;        
    }
    
    @Override
    public void loadProducts() throws CannotOpenFile {
        Scanner reader;
        try {
            reader = new Scanner(new BufferedReader(new FileReader(PRODUCT_RECORD)));
        } catch (FileNotFoundException e) {
            throw new CannotOpenFile("Trade record unable to be loaded.", e);
        }
        // Generic scanner generation
        // Reader is a class variable

        String currentLine;
        Product currentProduct;
        // Generic holding variables
        while (reader.hasNextLine()) {
            currentLine = reader.nextLine();
            if (currentLine.contains("ID")) {
                continue;
            }
            currentProduct = unmarshallProducts(currentLine);
            // Pass the current String into the unmarshall method
            // Method call returns an Product object
            products.put(currentProduct.getProductID(), currentProduct);
            // Add the current Ptoduct object to the Product HashMap
            
        }
        reader.close();
        // Close the reader
    }
    
    @Override
    public Product unmarshallProducts(String productText) {
        String[] productString = productText.split(DELIMITER);
        Product newProduct = new Product();        
        newProduct.setProductID(Integer.parseInt(productString[0]));
        newProduct.setProductName(productString[1]);
        newProduct.setProductPrice(Double.parseDouble(productString[2]));
        newProduct.setProductQuantity(Integer.parseInt(productString[3]));        
        return newProduct;
    }
    
}
