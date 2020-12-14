package Controller;

import DAO.CannotOpenFile;
import DAO.VendingMachineDAOImplementation;
import DAO.VendingMachineDAOInterface;
import DTO.Change;
import DTO.Product;
import ServiceLayer.InsufficientFundsException;
import ServiceLayer.InvalidDelimiterException;
import ServiceLayer.NoItemInventoryException;
import ServiceLayer.VendingMachineServiceLevel;
import ServiceLayer.VendingMachineServiceLevelImplementation;
import View.UserIO;
import View.UserIOConsoleImpl;
import View.VendingMachineView;
import java.util.List;

public class VendingMachineModelController {
    private VendingMachineServiceLevel service;
    private VendingMachineView view;
    UserIO io = new UserIOConsoleImpl();
    double balance = 0;

    public VendingMachineModelController(VendingMachineServiceLevel service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() throws CannotOpenFile, InvalidDelimiterException, InsufficientFundsException, NoItemInventoryException {
        //vendingMachineDao = new VendingMachineDAOImplementation();
        boolean keepGoing = true;
        int menuSelection = 0;
        balance += balanceUbdate();
        while (keepGoing) {
            switch (getMenuSelection()) {
                case 1:
                    viewAllTrades();
                    break;
                case 2:
                    purchase();
                    break;
                case 3:
                    view.exitMessage();
                    Change.coinsToChange(balance);
                    service.shutDown();
                    keepGoing = false;
                    break;
                default:
                    io.print("Unknown Command");
                    break;
            }
        }
    }

    private int getMenuSelection() {
        return view.printMenuandGetSelection();
    }

    private void viewAllTrades() {
        view.displayAllProductsBanner();
        List<Product> allProducts = service.getProducts();
        view.displayAllProducts(allProducts);
    }
    
    private void purchase() throws InsufficientFundsException, NoItemInventoryException, CannotOpenFile{        
        int productId = io.readInt("Enter a Product ID");
        try{
        balance = service.getPurchase(productId, balance);
        
        }catch (InsufficientFundsException ex){
            io.print(ex.getMessage());
            balance += balanceUbdate();
        }catch (NoItemInventoryException ex){
            io.print(ex.getMessage());
            productId = io.readInt("Enter a Product ID");
        }
        io.print("Your balance = " + balance);
    }

    private double balanceUbdate() {        
        return view.balanceUpdate("Please, put some money into machine:");
    }

}
