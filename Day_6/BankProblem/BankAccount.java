package Day_6.BankProblem;

import Day_2.BankProblem.Exceptions.InsufficientFundException;
import Day_2.BankProblem.Exceptions.InvalidAmountException;

public class BankAccount {
    private String accountNumber;
    private String accountName;
    private Double balance;
    private final Double TRANSFER_FEE = 10.00;
    private final String INVALID_AMOUNT_MESSAGE = " is not a valid amount.";
    private final String INSUFFICIENT_FUND_MESSAGE = "Insufficient funds";
    private static Double BANK_BALANCE = 0.0;

    public BankAccount(String accountName, String accountNumber) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public String withdraw(Double amount) throws InvalidAmountException, InsufficientFundException {
        if (isAmountValid(amount)) {
            if (isBalanceSufficient(amount)) {
                this.balance -= amount;
                BANK_BALANCE -= amount;
                return amount + " BDT debited successfully. Your new balance is " + balance;
            } else {
                throw new InsufficientFundException(INSUFFICIENT_FUND_MESSAGE);
            }
        } else {
            throw new InvalidAmountException(amount + INVALID_AMOUNT_MESSAGE);
        }
    }

    public String deposit(Double amount) throws InvalidAmountException {
        if (isAmountValid(amount)) {
            this.balance += amount;
            BANK_BALANCE += amount;
            return amount + " BDT successfully deposited. Your new balance is " + balance;
        } else {
            throw new InvalidAmountException(amount + " is not a valid amount.");
        }
    }

    public String transferFund(BankAccount targetAccount, Double amount)
            throws InvalidAmountException, InsufficientFundException {
        if (isAmountValid(amount)) {
            withdraw(amount + TRANSFER_FEE);
            targetAccount.deposit(amount);
            return amount + " BDT transferred to Account Name: " + targetAccount.getAccountName()
                    + " successfully. Your new balance is " + balance
                    + " Transfer fee: " + TRANSFER_FEE;
        } else {
            throw new InvalidAmountException(amount + INVALID_AMOUNT_MESSAGE);
        }
    }

    private Boolean isBalanceSufficient(Double amount) {
        return (balance - amount) >= 0;
    }

    private Boolean isAmountValid(Double amount) {
        // amount is invalid if it is negative or equal to 0
        return amount > 0;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String name) {
        this.accountName = name;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public static Double getBankBalance() {
        return BANK_BALANCE;
    }
}
