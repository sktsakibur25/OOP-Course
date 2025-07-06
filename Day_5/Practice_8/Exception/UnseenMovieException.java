package Day_5.Practice_8.Exception;

public class UnseenMovieException extends Exception {
    private String message;

    public UnseenMovieException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "UnseenMovieException: " + message;
    }
}
