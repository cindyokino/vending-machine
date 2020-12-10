package DAO;

public class CannotOpenFile extends Exception{
    CannotOpenFile(String message) {
        super(message);
    }
    CannotOpenFile(String message, Exception e) {
        super(message, e);
    }
}
