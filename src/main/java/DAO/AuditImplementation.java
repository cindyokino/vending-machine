/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Product;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author W
 */
public class AuditImplementation implements AuditInterface{
    public static final String AUDIT_FILE = "event_log.txt";    

    @Override
    public void recordProduct(Product soldProduct) throws CannotOpenFile {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new CannotOpenFile("Could not get audit file.", e);
        }
        LocalDateTime timestamp = LocalDateTime.now();

        out.println(timestamp.toString() +
                        " Product sold :  " + soldProduct.getProductID() +
                        "-" + soldProduct.getProductName() +
                        "| Price: " + soldProduct.getProductPrice() +
                        "| New Quantity: " +  soldProduct.getProductQuantity() +
                        "| ");
        out.flush();
    }  
}
