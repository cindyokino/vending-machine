package ServiceLayer;

import DAO.CannotOpenFile;
import DAO.VendingMachineDAOInterface;
import DTO.Product;
import java.util.List;

public class VendingMachineServiceLevelImplementation implements VendingMachineServiceLevel{
    VendingMachineDAOInterface dao;
    
    public VendingMachineServiceLevelImplementation(VendingMachineDAOInterface dao) {
        this.dao = dao;        
    }
    
    @Override
    public List<Product> getProducts() {
        return dao.getProducts();
    }   
    
    @Override
    public void saveProducts() throws CannotOpenFile {
        dao.saveProducts();
    }

    @Override
    public void shutDown() throws CannotOpenFile {
        saveProducts();
        dao.shutDown();
    }
}
