package ServiceLayer;


import DAO.AuditImplementation;
import DAO.AuditInterface;
import DAO.CannotOpenFile;
import DAO.VendingMachineDAOInterface;
import DTO.Product;
import java.util.List;

public class VendingMachineServiceLevelImplementation implements VendingMachineServiceLevel{
    VendingMachineDAOInterface dao;
    AuditInterface audit;
    
    public VendingMachineServiceLevelImplementation(VendingMachineDAOInterface dao) {
        this.dao = dao;    
        audit = new AuditImplementation();
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

    @Override
    public double getPurchase(int productId, double balance) throws InsufficientFundsException, NoItemInventoryException, CannotOpenFile {
        Product selectedProduct = getProduct(productId);
        if ( selectedProduct.getProductPrice() > balance){
            throw new InsufficientFundsException("Not enought money to purchase");
        }        
        selectedProduct.setProductQuantity(selectedProduct.getProductQuantity()-1);
        audit.recordProduct(selectedProduct);
        return (balance - selectedProduct.getProductPrice());
    }

    @Override
    public Product getProduct(int productID) throws NoItemInventoryException{
        if( dao.findProductById(productID)== null || dao.findProductById(productID).getProductQuantity()<=0) {
            throw new NoItemInventoryException("Cannot find product");
        }
        return dao.findProductById(productID);
    }    
    
}
