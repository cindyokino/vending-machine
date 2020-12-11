package App;

import DAO.CannotOpenFile;
import DAO.VendingMachineDAOImplementation;
import DAO.VendingMachineDAOInterface;
import DTO.Product;

import ServiceLayer.*;
import View.UserIO;
import View.UserIOConsoleImpl;
import View.VendingMachineView;
import ServiceLayer.VendingMachineServiceLevel;
import java.util.List;

/**
 *
 * @author Cindy Okino and Larisa Gargalic
 */
public class Application {

    public static void main(String[] args) throws CannotOpenFile, InvalidDelimiterException {
        //        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");       
        //        VendingMachineModelController controller= context.getBean("controller", VendingMachineModelController.class);
        //        controller.run();

        //VendingMachineServiceLevel service;
        VendingMachineDAOInterface vendingMachineDao = new VendingMachineDAOImplementation();
        VendingMachineServiceLevel service = new VendingMachineServiceLevelImplementation(vendingMachineDao); 
        UserIO userIo = new UserIOConsoleImpl();
        VendingMachineView view = new VendingMachineView(userIo);
        UserIO io = new UserIOConsoleImpl();
        
        
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            switch (view.printMenuandGetSelection()) {
                case 1:
                    view.displayAllProductsBanner();
                    List<Product> allProducts = vendingMachineDao.getProducts();
                    view.displayAllProducts(allProducts);
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
                case 5:
                    view.exitMessage();
                    service.shutDown();
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }        
  
}

}
