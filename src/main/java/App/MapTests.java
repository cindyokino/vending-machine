/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import DAO.CannotOpenFile;
import DAO.VendingMachineDAOImplementation;
import DAO.VendingMachineDAOInterface;
import DTO.Product;
import ServiceLayer.InsufficientFundsException;
import ServiceLayer.NoItemInventoryException;
import ServiceLayer.ProductNotFoundException;
import ServiceLayer.VendingMachineServiceLevel;
import ServiceLayer.VendingMachineServiceLevelImplementation;
import View.UserIO;
import View.UserIOConsoleImpl;
import View.VendingMachineView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Cindy
 */
public class MapTests {
    public static void main(String[] args) throws CannotOpenFile {
            
            Map<Integer, Product> productsDatabase = loadProducts();
            VendingMachineDAOInterface vendingMachineDao = new VendingMachineDAOImplementation(productsDatabase);
            VendingMachineServiceLevel machineService = new VendingMachineServiceLevelImplementation(vendingMachineDao);            
            UserIO userIo = new UserIOConsoleImpl();
            VendingMachineView view = new VendingMachineView(userIo);

           
            int option = 0;
            do {
                option = view.selectManageOrdersOptions();
                if(option == 1){
                    machineService.listAllProducts();                
                } else if(option == 2) {
                    double money = userIo.readDouble("Please insert your money: ");
                    machineService.listAllProducts();
                    int desiredProductId = userIo.readInt("Choose the number for the desired product");
                    try {
                        machineService.purchase(desiredProductId, money);
    //                int productOption = userIo.readInt("");
                    } catch (ProductNotFoundException ex) {
                        userIo.print("The product you entered was not found, please try again with different product");
                    } catch (NoItemInventoryException ex) {
                        System.out.println("The product you entered is out of stock, please choose another product");
                    } catch (InsufficientFundsException ex) {
                        System.out.println("Please try again with more funds");
                    } 
                } else if (option != 3) {
                    userIo.print("Wrong option, please try again");
                }
            } while (option != 3);
            
            userIo.print("good bye");            
    }
    
    
     private static Map<Integer, Product> loadProducts() throws CannotOpenFile {
        Scanner reader;
        Map<Integer, Product> products = new HashMap<>();
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
        
        return products;
        // Close the reader
    }
    
    private static Product unmarshallProducts(String productText) {
        String[] productString = productText.split("::");
        Product newProduct = new Product();        
        newProduct.setProductID(Integer.parseInt(productString[0]));
        newProduct.setProductName(productString[1]);
        newProduct.setProductPrice(Double.parseDouble(productString[2]));
        newProduct.setProductQuantity(Integer.parseInt(productString[3]));        
        return newProduct;
    }
}
