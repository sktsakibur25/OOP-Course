package Day_2.BankProblem;

import java.util.UUID;

public class BankProgramMain {
    public static void main(String[] args) {
        try {
            BankAccount account_1 = new BankAccount("Sakibur Rahman", UUID.randomUUID().toString());
            BankAccount account_2 = new BankAccount("Tanvir Rahman", UUID.randomUUID().toString());

            String message = account_1.deposit(10000.00);
            System.out.println(message);

            message = account_1.withdraw(5000.0);
            System.out.println(message);

            message = account_1.transferFund(account_2, 2000.0);
            System.out.println(message);

            message = account_1.withdraw(5000.0);
            System.out.println(message);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
