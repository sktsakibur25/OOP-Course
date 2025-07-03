package Day_5.Practic_6.Exceptions;

public class CarNotFoundException extends Exception {
    private String message;

    public CarNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CarNotFoundException: " + message;
    }
}
