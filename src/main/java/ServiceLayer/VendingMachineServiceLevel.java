package ServiceLayer;

import DAO.CannotOpenFile;
import DTO.Product;
import java.util.List;

public interface VendingMachineServiceLevel {
    List<Product> getProducts();  
    void saveProducts() throws CannotOpenFile;
    void shutDown() throws CannotOpenFile;
}

