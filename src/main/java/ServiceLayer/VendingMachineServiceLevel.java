package ServiceLayer;

import DAO.CannotOpenFile;
import DTO.Product;
import java.util.List;

public interface VendingMachineServiceLevel {
    List<Product> getProducts();  
    void saveProducts() throws CannotOpenFile;
    void shutDown() throws CannotOpenFile;
    double getPurchase(int productId, double balance) throws InsufficientFundsException, NoItemInventoryException, CannotOpenFile;
    Product getProduct(int productID)throws NoItemInventoryException;
}

