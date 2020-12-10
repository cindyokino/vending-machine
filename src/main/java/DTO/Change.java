package DTO;

public class Change {
    
    double amountOfChange;
//    int dollar; // 1 dollar
    int quarter; // 25 cents
    int dime; // 10 cents
    int nickel; // 5 cents
    int penny; // 1 cent
    
    public Change() {
        
    }
    
    public Change(double change) {
        this.amountOfChange = change;
    }
    
    public int getQuarter() {
        return quarter;
    }
    
    public int getDime() {
        return dime;
    }
    
    public int getNickel() {
        return nickel;
    }
    
    public int getPenny() {
        return penny;
    }
    
    
    public static void coinsToChange(double amountOfChange) {
        Change change = new Change();
        int totalCents = (int)amountOfChange * 100;
        
        change.quarter = totalCents / 25;
        int remaining1 = totalCents % 25;
        
        change.dime = remaining1 / 10;
        int remaining2 = remaining1 % 10;
        
        change.nickel = remaining2 / 5;
        change.penny = remaining2 % 5;  
                
        System.out.print(change.quarter + " quarters, " + change.dime + " dimes, " + change.nickel + " nickels, " + change.penny + " pennys");
    }
}
