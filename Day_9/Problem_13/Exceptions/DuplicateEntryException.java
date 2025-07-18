package Day_9.Problem_13.Exceptions;

public class DuplicateEntryException extends Exception {
    private String message;

    public DuplicateEntryException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "DuplicateEntryException: " + message;
    }
}
