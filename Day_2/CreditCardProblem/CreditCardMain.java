package Day_2.CreditCardProblem;

import Day_2.BankProblem.Exceptions.InvalidAmountException;
import Day_2.CreditCardProblem.Exceptions.CreditCardLimitException;

public class CreditCardMain {
    public static void main(String[] args) {
        try {
            CreditCard card = new CreditCard();
            String message = card.withDraw(5000.0, PaymentType.CASH_WITHDRAWAL);
            System.out.println(message);

            message = card.withDraw(100000.0, PaymentType.BILL_PAYMENT);
            System.out.println(message);
            
        } catch (InvalidAmountException iae) {
            System.err.println(iae.getMessage());
        } catch (CreditCardLimitException cclm) {
            System.err.println(cclm.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
