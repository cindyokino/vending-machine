/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author W
 */
public interface VendingMachineDAOInterface {
    void loadProducts() throws CannotOpenFile;
    // Loads the Order objects in a given file into memory    
}
