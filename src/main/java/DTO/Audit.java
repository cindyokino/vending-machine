package DTO;

import java.time.LocalDateTime;

public class Audit {
    
    int auditID;
    int productID;
    String productName;
    LocalDateTime transactionDate = LocalDateTime.now();  
    
     public Audit () {
        
    }
    
    public Audit (int id, String name) {
        this.productID = id;
        this.productName = name;
    }
    
    public int getAuditID() {
        return auditID;
    }
    
    public int getProductID() {
        return productID;
    }
    
    public void setProductID(int id) {
        this.productID = id;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String name) {
        this.productName = name;
    }
}
