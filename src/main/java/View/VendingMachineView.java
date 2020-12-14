package View;

import DTO.Product;
import java.util.List;
import java.util.Scanner;

public class VendingMachineView {

    private UserIO io = new UserIOConsoleImpl();

    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    Scanner scan = new Scanner(System.in);

    // MANAGE ORDERS
    public int printMenuandGetSelection() {
        io.print("***Vending Machine Options***");
        io.print("1. List all Products");        
        io.print("2. Purchase");      
        io.print("3. Exit");
        return io.readInt("Please select from the above choices.", 1,3);
    }

    public void exitMessage() {
        io.print("Goodbye.");
    }

    public void displayAllProductsBanner() {
        io.print("=== Displaying All Products In Window===");
    }

    public void displayAllProducts(List<Product> allProducts) {
        for (Product p : allProducts) {
            String tradeInfo = String.format("%d : %s : %f : %d ",
                    p.getProductID(),
                    p.getProductName(),
                    p.getProductPrice(),
                    p.getProductQuantity());
            io.print(tradeInfo);
        }
        io.readString("Please hit enter to continue.");

    }
    
    public double balanceUpdate(String balance){
        return io.readDoublePositive(balance);
    }
}
