package Day_7.Practice_10;

import java.time.LocalDate;

public class BankSystem {
    public static final Integer CREDIT_CARD_USAGE_ELIGIBLE_AGE = 18;
    public static void main(String[] args) {
        

        // Create two customers with their credit cards
        Customer customer1 = new Customer("Sakibur Rahman", LocalDate.of(1995, 5, 15), "Dhaka, Bangladesh");
        customer1.displayCustomerInfo();
        System.out.println();
        customer1.makePayment(5000.0, PaymentType.BILL_PAYMENT);
        System.out.println();
        customer1.makePayment(2000.0, PaymentType.CASH_WITHDRAWAL);

        System.out.println();
        Customer customer2 = new Customer("Tanvir Rahman", LocalDate.of(1998, 3, 20), "Chittagong, Bangladesh");
        customer2.displayCustomerInfo();
        System.out.println();
        customer2.makePayment(15000.0, PaymentType.BILL_PAYMENT);
        System.out.println();
        customer2.makePayment(5000.0, PaymentType.CASH_WITHDRAWAL);
        System.out.println();
        customer2.displayCustomerInfo();
        System.out.println();

        Customer customer3 = new Customer("Mahfuz Rahman", LocalDate.of(2010, 3, 20), "Noakhali, Bangladesh");
        customer3.displayCustomerInfo();
        System.out.println();
        customer3.makePayment(15000.0, PaymentType.BILL_PAYMENT);
        System.out.println();


    }
}
