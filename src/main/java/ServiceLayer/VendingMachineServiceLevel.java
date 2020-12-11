package ServiceLayer;

import DTO.Change;
import DTO.Product;

public interface VendingMachineServiceLevel {       
    
    void listAllProducts();
    
    Change purchase(int productId, double money) throws ProductNotFoundException, NoItemInventoryException;        
}
