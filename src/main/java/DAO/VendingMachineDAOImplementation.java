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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author W
 */
public class VendingMachineDAOImplementation implements VendingMachineDAOInterface{
    Map<Integer, Product> products;  
    public static final String DELIMITER = "::";

    public VendingMachineDAOImplementation(Map<Integer, Product> productsDatabase) {
        this.products = productsDatabase;
    }

    @Override
    public List<Product> findAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findProductById(int id) {
        return products.get(id);         
    }   

    @Override
    public void saveProducts(Map<Integer, Product> productsDatabase) throws CannotOpenFile {
        Map<Integer, Product> products = new HashMap<>();
        PrintWriter writer;
        try {
            writer = new PrintWriter(new FileWriter("product_file.txt"));
            // Open it for editing.
        } catch (IOException e) {
            throw new CannotOpenFile("Cannot write to product record file.");
        }
        writer.println("ID::NAME::PRICE::QUANTITY");
        for (Product thisProduct : products.values()) {
            writer.println(marshallProduct(thisProduct));
            // marshall it to that file
        }
        writer.close();
    }

    @Override
    public String marshallProduct(Product product) {
        String tradeString = product.getProductID() + DELIMITER;
        tradeString += product.getProductName() + DELIMITER;
        tradeString += product.getProductPrice() + DELIMITER;
        tradeString += product.getProductQuantity();        
        return tradeString;
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

    @Override
    public void loadProducts() throws CannotOpenFile {
        Scanner reader;
        
        try {
            reader = new Scanner(new BufferedReader(new FileReader("product_file.txt")));
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
    
    
}
