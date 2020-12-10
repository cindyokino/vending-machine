package DTO;

public class Product {
    
    int productID;
    String productName;
    Double productPrice;
    int productQuantity; 
    
    public Product () {
        
    }
    
    public Product (String name, Double price, int quantity) {
        this.productName = name;
        this.productPrice = price;
        this.productQuantity = quantity;
    }
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String name) {
        this.productName = name;
    }
    
    public Double getProductPrice() {
        return productPrice;
    }
    
    public void setProductPrice(Double price) {
        this.productPrice = price;
    }
     
    public int getProductQuantity() {
        return productQuantity;
    }
    
    public void setProductQuantity(int quantity) {
        this.productQuantity = quantity;
    }
}
