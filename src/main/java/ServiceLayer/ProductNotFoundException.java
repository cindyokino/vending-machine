package ServiceLayer;

public class ProductNotFoundException extends Exception{
    ProductNotFoundException(String message) {
        super(message);
    }
    ProductNotFoundException(String message, Exception e) {
        super(message, e);
    }     
}
