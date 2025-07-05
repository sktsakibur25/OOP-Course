package Day_5.Practice_7.Exceptions;

public class StudentAlreadyExistsException extends Exception {
    private String message;

    public StudentAlreadyExistsException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "StudentAlreadyExistsException: " + message;
    }
}
