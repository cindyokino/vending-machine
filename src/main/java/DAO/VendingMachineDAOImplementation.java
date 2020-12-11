/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author W
 */
public class VendingMachineDAOImplementation implements VendingMachineDAOInterface{
    Map<Integer, Product> products;    

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
    
    
    
}
