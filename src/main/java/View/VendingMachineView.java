package View;

import java.util.Scanner;

public class VendingMachineView {
    private UserIO io = new UserIOConsoleImpl();
    
    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    Scanner scan = new Scanner(System.in);
    // MANAGE ORDERS
    public int selectManageOrdersOptions(){
        io.print("***Manage Orders Options***");
        io.print("1. List all Products");
        io.print("2. Purchase");      
        io.print("3. Exit");
        return io.readInt("Please select from the above choices.", 1,3);
    }
}
