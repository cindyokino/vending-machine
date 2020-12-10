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
        io.print("2. Put money");
        io.print("3. See balance");
        io.print("4. Select product from the list");
        io.print("5. Exit");
        return io.readInt("Please select from the above choices.", 1,3);
    }
}
