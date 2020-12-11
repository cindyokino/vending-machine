package ServiceLayer;

import DTO.Change;

public interface VendingMachineServiceLevel {       
    
    void listAllProducts();
    
    Change purchase(int productId, double money) throws ProductNotFoundException, NoItemInventoryException, InsufficientFundsException;
        
}
