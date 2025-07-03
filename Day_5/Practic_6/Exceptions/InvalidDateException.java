package Day_5.Practic_6.Exceptions;

public class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "InvalidDateException: " + getMessage();
    }
}
