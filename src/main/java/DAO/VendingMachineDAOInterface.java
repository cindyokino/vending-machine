package DAO;

import DTO.Product;
import java.util.List;

public interface VendingMachineDAOInterface {
    void loadProducts() throws CannotOpenFile;
    // Loads the Product objects in a given file into memory    
    Product unmarshallProducts(String productText);
    // Unpack the Product objects to be stored in a HashMap
    void shutDown() throws CannotOpenFile;
    // Final program call, ensures Trade objects are saved.
    void saveProducts() throws CannotOpenFile;
    // Store the Products objects in a file
    String marshallProduct(Product product);
    // Pack the Trade objects to be stored in a file
    List<Product> getProducts();
    // Return a list of trades
}
