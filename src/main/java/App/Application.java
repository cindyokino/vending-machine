package App;

import Controller.VendingMachineModelController;
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
        VendingMachineDAOInterface vendingMachineDao = new VendingMachineDAOImplementation();
        VendingMachineServiceLevel service = new VendingMachineServiceLevelImplementation(vendingMachineDao); 
        UserIO userIo = new UserIOConsoleImpl();
        VendingMachineView view = new VendingMachineView(userIo);
        VendingMachineModelController controller = new VendingMachineModelController(service,view);
        controller.run();     
  
}

}
