package Day_9.Problem_13.Exceptions;

public class MedicineContradictionException extends Exception {
    private String message;

    public MedicineContradictionException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MedicineContradictionException: " + message;
    }
    
    public String getMessage() {
        return message;
    }
}
