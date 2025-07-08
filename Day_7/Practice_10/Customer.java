package Day_7.Practice_10;

import java.time.LocalDate;

import Day_7.Practice_10.Exceptions.CreditCardExpiredException;
import Day_7.Practice_10.Exceptions.CreditCardLimitException;
import Day_7.Practice_10.Exceptions.CustomerIsUnderAgedException;
import Day_7.Practice_10.Exceptions.InvalidAmountException;
import Day_7.Practice_10.Exceptions.InvalidPaymentTypeException;

public class Customer {
    private String name;
    private LocalDate dateOfBirth;
    private CreditCard creditCard;
    private String address;

    public Customer(String name, LocalDate dateOfBirth, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.creditCard = new CreditCard(); // Automatically generates a credit card for the customer
    }

    public Double getAvailableTotalBalance() {
        return creditCard.getAvailableTotalBalance();
    }

    public Double getAvailableDailyBalance() {
        return creditCard.getAvailableDailyBalance();
    }

    public void makePayment(Double amount, PaymentType paymentType){
        try {
            checkCustomerAge();
            creditCard.withDraw(amount, paymentType);
            System.out.println("Payment successful: " + amount + " using " + paymentType);
        } catch (CreditCardExpiredException e) {
            System.out.println("Payment failed: " + e.getMessage());
        } catch (InvalidPaymentTypeException e) {
            System.out.println("Payment failed: " + e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println("Payment failed: " + e.getMessage());
        } catch (CreditCardLimitException e) {
            System.out.println("Payment failed: " + e.getMessage());
        } catch (CustomerIsUnderAgedException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }catch (Exception e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
    }

    private void checkCustomerAge() throws CustomerIsUnderAgedException {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - dateOfBirth.getYear();
        if(age < BankSystem.CREDIT_CARD_USAGE_ELIGIBLE_AGE) {
            throw new CustomerIsUnderAgedException("Customer must be at least " + BankSystem.CREDIT_CARD_USAGE_ELIGIBLE_AGE + " years old to use a credit card.");
        }
    }

    public void displayCustomerInfo() {
        System.out.println("Customer Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Address: " + address);
        System.out.println("Credit Card Number: " + creditCard.getCardNumber().substring(0, 4) + " **** **** ****");
        System.out.println("Available Total Balance: " + getAvailableTotalBalance());
        System.out.println("Available Daily Balance: " + getAvailableDailyBalance());
    }
}
