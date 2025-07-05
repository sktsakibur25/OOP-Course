package Day_5.Practice_7.Exceptions;

public class AssignmentSubmissionClosedException extends Exception {
    private String message;

    public AssignmentSubmissionClosedException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "AssignmentSubmissionClosedException: " + message;
    }
}
