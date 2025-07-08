package Day_7.Practice_10.Exceptions;

public class CustomerIsUnderAgedException extends Exception {
    private String message;

    public CustomerIsUnderAgedException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
