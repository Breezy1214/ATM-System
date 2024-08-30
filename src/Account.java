import java.io.Serializable;
import java.util.HashMap;

public class Account implements Serializable {
    HashMap<Integer, Integer> data = new HashMap<>();
    private int accountNumber;
    private double checkingBalance = 0;
    private double savingsBalance = 0;
    private int accountPin;

    public Account(int accountNumber, int pinNumber) {
        this.accountNumber = accountNumber;
        this.accountPin = pinNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountPin() {
        return accountPin;
    }

    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void withdrawSavings(double amount) {
        if (savingsBalance - amount < 0) {
            System.out.println("Insufficient funds");
        } else {
            savingsBalance -= amount;
            System.out.println("Withdrawal of $" + amount + " processed. Remaining savings balance: $" + savingsBalance);
        }
    }

    public void depositSavings(double amount) {
        savingsBalance += amount;
        System.out.println("Deposit of $" + amount + " processed. New savings balance: $" + savingsBalance);
    }

    public void withdrawChecking(double amount) {
        if (checkingBalance - amount < 0) {
            System.out.println("Insufficient funds");
        } else {
            checkingBalance -= amount;
            System.out.println("Withdrawal of $" + amount + " processed. Remaining checking balance: $" + checkingBalance);
        }
    }

    public void depositChecking(double amount) {
        checkingBalance += amount;
        System.out.println("Deposit of $" + amount + " processed. New checking balance: $" + checkingBalance);
    }
}
