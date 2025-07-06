package Day_5.Practice_8.Exception;

public class InvalidRateValueException extends Exception {
    private String message;

    public InvalidRateValueException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "InvalidRateValueException: " + message;
    }
}
