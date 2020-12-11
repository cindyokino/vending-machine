/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Product;
import java.util.List;

/**
 *
 * @author W
 */
public interface VendingMachineDAOInterface {
    
    
    Product findProductById(int id);
//    
//    void deleteProductById(int id);
//    
//    Product createProduct(Product product);
//    
    List<Product> findAllProducts();
    
    
//    void loadProducts() throws CannotOpenFile;
//    // Loads the Order objects in a given file into memory    
//    Product unmarshallProducts(String productText);
//    // Unpack the Trade objects to be stored in a HashMap
}
