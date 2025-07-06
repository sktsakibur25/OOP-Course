package Day_5.Practice_8.Exception;

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
