package Day_2.CreditCardProblem;

import Day_2.BankProblem.Exceptions.InvalidAmountException;
import Day_2.CreditCardProblem.Exceptions.CreditCardLimitException;
import Day_2.CreditCardProblem.Exceptions.InvalidPaymentTypeException;

public class CreditCard {
    private final Double MAXIMUM_LIMIT = 500000.0;
    private final Double DAILY_LIMIT = 100000.0;
    private final Double TRANSACTION_LIMIT = 20000.0;

    // This value should reset to 0.0 with a cron job in a working server on daily basis
    private Double spent_today = 0.0; 
    // This value should reset to 0.0 with a cron job in a working server on monthly
    // or billing cycle basis 
    private Double total_spent = 0.0;

    public String withDraw(Double amount, PaymentType paymentType) throws InvalidPaymentTypeException, InvalidAmountException,
                                                                          CreditCardLimitException{
        
       if(isAmountValid(amount)){
        switch (paymentType) {
            case BILL_PAYMENT ->{
                if(isWithinMaximumLimit(amount)){
                    total_spent += amount;
                    return "Bill paid of :"+amount;
                }else{
                   throw new CreditCardLimitException("Maximum Limit Exceeded");  
                }
            }
            case CASH_WITHDRAWAL ->{
                if(isWithinMaximumLimit(amount)){
                    if(isWithinDailyLimit(amount)){
                        if(isWithinTransactionLimit(amount)){
                            spent_today += amount;
                            total_spent += amount;
                            return "Balance withdrawn of :"+amount;
                        }else{
                            throw new CreditCardLimitException("Single transaction limit exceeded");
                        }
                    }else{
                        throw new CreditCardLimitException("Daily transaction limit exceeded");
                    }
                }else{
                   throw new CreditCardLimitException("Maximum Limit Exceeded");  
                }
            }
            default -> {
                throw new InvalidPaymentTypeException("Invalid payment type : " + paymentType);
            }
        }
       }else{
            throw new InvalidAmountException("Invalid Amount : "+amount);
       }
    }

    private Boolean isWithinDailyLimit(Double amount) {
        return (spent_today + amount) <= DAILY_LIMIT;
    }

    private Boolean isWithinTransactionLimit(Double amount) {
        return (amount) <= TRANSACTION_LIMIT;
    }

    private Boolean isWithinMaximumLimit(Double amount) {
        return (this.total_spent + amount) <= MAXIMUM_LIMIT;
    }

    private Boolean isAmountValid(Double amount) {
        // amount is invalid if it is negative or equal to 0
        return amount > 0;
    }

}
