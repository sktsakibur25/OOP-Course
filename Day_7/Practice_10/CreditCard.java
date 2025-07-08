package Day_7.Practice_10;

import java.time.LocalDate;
import java.util.Random;

import javax.security.auth.login.CredentialExpiredException;

import Day_7.Practice_10.Exceptions.InvalidAmountException;
import Day_7.Practice_10.Exceptions.CreditCardLimitException;
import Day_7.Practice_10.Exceptions.InvalidPaymentTypeException;
import Day_7.Practice_10.Exceptions.CreditCardExpiredException;

public class CreditCard {
    private String cardNumber;
    private LocalDate expiryDate;
    private Integer cvc;
    private final Double MAXIMUM_LIMIT = 500000.0;
    private final Double DAILY_LIMIT = 100000.0;
    private final Double TRANSACTION_LIMIT = 20000.0;

    // This value should reset to 0.0 with a cron job in a working server on daily
    // basis
    private Double spent_today = 0.0;
    // This value should reset to 0.0 with a cron job in a working server on monthly
    // or billing cycle basis
    private Double total_spent = 0.0;

    public CreditCard() {
        this.cardNumber = generateCardNumber();
        this.expiryDate = LocalDate.now().plusYears(5); // Default expiry date is 5 years from now
        this.cvc = generateCVC(); // Generates a random CVC between 100 and 999
    }

    public String withDraw(Double amount, PaymentType paymentType)
            throws InvalidPaymentTypeException, InvalidAmountException,
            CreditCardLimitException, CreditCardExpiredException {

        checkExpiryDate();

        if (isAmountValid(amount)) {
            switch (paymentType) {
                case BILL_PAYMENT -> {
                    if (isWithinMaximumLimit(amount)) {
                        total_spent += amount;
                        return "Bill paid of :" + amount;
                    } else {
                        throw new CreditCardLimitException("Maximum Limit Exceeded");
                    }
                }
                case CASH_WITHDRAWAL -> {
                    if (isWithinMaximumLimit(amount)) {
                        if (isWithinDailyLimit(amount)) {
                            if (isWithinTransactionLimit(amount)) {
                                spent_today += amount;
                                total_spent += amount;
                                return "Balance withdrawn of :" + amount;
                            } else {
                                throw new CreditCardLimitException("Single transaction limit exceeded");
                            }
                        } else {
                            throw new CreditCardLimitException("Daily transaction limit exceeded");
                        }
                    } else {
                        throw new CreditCardLimitException("Maximum Limit Exceeded");
                    }
                }
                default -> {
                    throw new InvalidPaymentTypeException("Invalid payment type : " + paymentType);
                }
            }
        } else {
            throw new InvalidAmountException("Invalid Amount : " + amount);
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

    private String generateCardNumber() {
        Random random = new Random();
        int number1 = 1000 + random.nextInt(9000); // ensures number is between 1000–9999
        int number2 = 1000 + random.nextInt(9000); // ensures number is between 1000–9999
        int number3 = 1000 + random.nextInt(9000); // ensures number is between 1000–9999
        int number4 = 1000 + random.nextInt(9000); // ensures number is between 1000–9999
        return String.valueOf(number1) + " " + String.valueOf(number2) + " " + String.valueOf(number3) + " "
                + String.valueOf(number4);
    }

    private Integer generateCVC() {
        Random random = new Random();
        return 100 + random.nextInt(900); // ensures CVC is between 100–999
    }

    private void checkExpiryDate() throws CreditCardExpiredException {
        if (LocalDate.now().isAfter(expiryDate)) {
            throw new CreditCardExpiredException("Credit Card Expired");
        }
    }

    public Double getAvailableTotalBalance() {
        return MAXIMUM_LIMIT - total_spent;
    }

    public Double getAvailableDailyBalance() {
        return DAILY_LIMIT - spent_today;
    }

    public String getCardNumber() {
        return cardNumber;
    }

}
