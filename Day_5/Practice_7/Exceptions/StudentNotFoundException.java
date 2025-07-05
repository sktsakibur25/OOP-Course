package Day_5.Practice_7.Exceptions;

public class StudentNotFoundException extends Exception {
    private String message;

    public StudentNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "StudentNotFoundException: " + message;
    }
}
