package Day_7.Practice_10.Exceptions;

public class CreditCardLimitException extends Exception {
    public CreditCardLimitException(String message){
        super(message);
    }
}
