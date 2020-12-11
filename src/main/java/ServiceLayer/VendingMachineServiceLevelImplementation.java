package ServiceLayer;

import DAO.VendingMachineDAOInterface;
import DTO.Change;
import DTO.Product;

public class VendingMachineServiceLevelImplementation implements VendingMachineServiceLevel {

    VendingMachineDAOInterface dao;

    public VendingMachineServiceLevelImplementation(VendingMachineDAOInterface dao) {
        this.dao = dao;
    }

    public void calculateAmountOfChange() {

    }

    @Override
    public void listAllProducts() {
        dao.findAllProducts().forEach(product -> {
            if (product.getProductQuantity() > 0) {
                System.out.println(product.getProductID() + " - " + product.getProductName() + " --- " + product.getProductPrice() + " --- " + product.getProductQuantity());
            }
        });
    }

    @Override
    public Change purchase(int productId, double money) throws ProductNotFoundException, NoItemInventoryException, InsufficientFundsException {

        Product chosenProduct = dao.findProductById(productId);
        if (chosenProduct == null) {
            throw new ProductNotFoundException("");
        }
        if (chosenProduct.getProductQuantity() == 0) {
            throw new NoItemInventoryException("");
        }
        if (money < chosenProduct.getProductPrice()) {
            throw new InsufficientFundsException("");
        }
        chosenProduct.setProductQuantity(chosenProduct.getProductQuantity() - 1);
        double calculatedChange = money - chosenProduct.getProductPrice();

        return Change.coinsToChange(calculatedChange);

    }
}
