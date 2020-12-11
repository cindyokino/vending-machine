package DAO;

import DTO.Product;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AuditImplementation implements AuditInterface{
    public static final String AUDIT_FILE = "event_log.txt";
    VendingMachineDAOInterface dao;

    public AuditImplementation(VendingMachineDAOInterface dao) {
        this.dao = dao;
    }

    @Override
    public void recordProduct(int soldProductId) throws CannotOpenFile {
        PrintWriter out;        
        Product soldProduct = dao.findProductById(soldProductId);
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
