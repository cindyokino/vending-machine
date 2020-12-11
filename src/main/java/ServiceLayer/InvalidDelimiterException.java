package ServiceLayer;

public class InvalidDelimiterException extends Exception {
    InvalidDelimiterException(String message) {
        super(message);
    }

    InvalidDelimiterException(String message, Exception e) {
        super(message, e);
    }
}
