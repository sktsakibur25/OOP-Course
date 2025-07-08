package Day_7.Practice_10.Exceptions;

public class InvalidPaymentTypeException extends Exception {
    public InvalidPaymentTypeException(String message){
        super(message);
    }
}
