package DAO;

public class CannotOpenFile extends Exception{
    public CannotOpenFile(String message) {
        super(message);
    }
    public CannotOpenFile(String message, Exception e) {
        super(message, e);
    }
}
