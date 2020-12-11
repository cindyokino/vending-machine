package Controller;

import DAO.CannotOpenFile;
import DTO.Product;
import ServiceLayer.InvalidDelimiterException;
import ServiceLayer.VendingMachineServiceLevel;
import View.UserIO;
import View.UserIOConsoleImpl;
import View.VendingMachineView;
import java.util.List;

public class VendingMachineModelController {
    private VendingMachineServiceLevel service;
    private VendingMachineView view;
    private UserIO io = new UserIOConsoleImpl();
    public VendingMachineModelController(VendingMachineServiceLevel service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() throws CannotOpenFile, InvalidDelimiterException  {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing){
            switch (getMenuSelection()){
                case 1:
                    viewAllTrades();
                    break;
                case 2:
                    //manageOrders();
                    break;
                case 3:
                    //displayOrderBook();
                    break;
                case 4:
                    //manageOrders();
                    break;
                case 5: view.exitMessage();
                    service.shutDown();
                    keepGoing = false;
                    break;
                default:System.out.println("Unknown Command");
                    break;
            }
        }
    }
    private int getMenuSelection(){
        return view.printMenuandGetSelection();
    }
    
    private void viewAllTrades(){
        view.displayAllProductsBanner();
        List<Product> allProducts = service.getProducts();
        view.displayAllProducts(allProducts);
    }
    
}
