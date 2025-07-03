package Day_5.Practic_6.Exceptions;

public class InvalidInputException extends Exception {
    private String message;

    public InvalidInputException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "InvalidInputException: " + message;
    }
}
