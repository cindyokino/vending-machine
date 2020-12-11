package ServiceLayer;

import DAO.VendingMachineDAOInterface;
import DTO.Change;
import DTO.Product;
import java.util.Scanner;

public class VendingMachineServiceLevelImplementation implements VendingMachineServiceLevel{
    
    VendingMachineDAOInterface dao;
    
    public VendingMachineServiceLevelImplementation(VendingMachineDAOInterface dao) {
        this.dao = dao;
    }  
    
    
    
    public void calculateAmountOfChange() {
        
    }

    @Override
    public void listAllProducts() {
        System.out.println("");
       dao.findAllProducts().forEach(product -> {
           System.out.println(product.getProductID() + " - " + product.getProductName() + " - $" + product.getProductPrice() + " - in stock: " + product.getProductQuantity());
       });
    }

    @Override
    public Change purchase(int productId, double money) throws ProductNotFoundException, NoItemInventoryException {
        
        Product chosenProduct = dao.findProductById(productId);
        if (chosenProduct == null) {
            throw new ProductNotFoundException("");
        }
        if (chosenProduct.getProductQuantity() == 0) {
            throw new NoItemInventoryException("");
        }
        while (money < chosenProduct.getProductPrice()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("You have not enough money. Please try again with more funds");
            System.out.println("Please insert your money:");
            double addMoney = sc.nextDouble();
            money += addMoney;
        }
        
        chosenProduct.setProductQuantity(chosenProduct.getProductQuantity() -1);
        double calculatedChange = money - chosenProduct.getProductPrice();
        
        return Change.coinsToChange(calculatedChange);
        
    }   
    
//    @Override
//    public Double insertMoreMoney(Product chosenProduct, double money) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please try again with more funds");
//        System.out.println("Please insert your money:");
//        double addMoney = sc.nextDouble();
//        money += addMoney;
//        return money;
//    }
    
}