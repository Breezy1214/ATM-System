import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static final String SELECTION_TEXT = "Enter your selection: ";
    private static final String INVALID_SELECTION = "Invalid selection";
    private static final String INVALID_INPUT = "Invalid input";
    private static final Scanner menuInput = new Scanner(System.in);
    private static Account account;
    private Menu() {
    }
    
    private static void checkBalance(){
        System.out.println();
        System.out.println("1. Check Checking Balance");
        System.out.println("2. Check Savings Balance");
        System.out.println("3. Go back");
        System.out.print(SELECTION_TEXT);
        boolean exit = false;

        do{
            try {
                int selection = menuInput.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("Checking: $" + account.getCheckingBalance());
                        break;
                    case 2:
                        System.out.println("Savings: $" + account.getSavingsBalance());
                        break;
                    case 3:
                        exit = true;
                        getMenuSelection();
                        break;
                    default:
                        System.out.println(INVALID_SELECTION);
                        System.out.print(SELECTION_TEXT);
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println(INVALID_INPUT);
                System.out.print(SELECTION_TEXT);
                menuInput.next();
            }
        }

        while (!exit);
    }

    private static void withdraw() {
        System.out.println();
        System.out.println("1. Withdraw from Checking");
        System.out.println("2. Withdraw from Savings");
        System.out.println("3. Go back");
        System.out.print(SELECTION_TEXT);
        boolean exit = false;

        do {
            try {
                int selection = menuInput.nextInt();

                switch (selection) {
                    case 1:
                        exit = true;
                        System.out.println("Enter amount to withdraw from Checking: ");
                        break;
                    case 2:
                        exit = true;
                        System.out.println("Enter amount to withdraw from Savings: ");
                        break;
                    case 3:
                        exit = true;
                        getMenuSelection();
                        break;
                    default:
                        System.out.println(INVALID_SELECTION);
                        System.out.print(SELECTION_TEXT);
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println(INVALID_INPUT);
                System.out.print(SELECTION_TEXT);
                menuInput.next();
            }
        }

        while (!exit);
    }

    private static void getMenuSelection() {
        System.out.println();
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
        System.out.print(SELECTION_TEXT);
        int selection = menuInput.nextInt();
        boolean exit = false;

        while (!exit){
            switch (selection){
                case 1:
                    exit = true;
                    checkBalance();
                    break;
                case 2:
                    exit = true;
                    withdraw();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Enter amount to deposit: ");
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println(INVALID_SELECTION);
                    System.out.print(SELECTION_TEXT);
                    menuInput.next();
            }
        }


    }

    public static void getLogin() {
        Database database = (Database) FileHandler.loadState("AccountData");

        if (database == null) {
            Account acc1 = new Account(12356797, 12345);
            database = Database.getInstance();
            database.addAccount(acc1);

            System.out.println("Created " + database.getAccount(acc1.getAccountNumber()));

            try {
                FileHandler.saveState(database, "AccountData");
            } catch (IOException e) {
                System.out.println("Error saving state: " + e.getMessage());
            }
        }

        System.out.println("Welcome to the ATM");

        while (true) {
            try {
                System.out.print("Enter your Account number: ");
                int accountNumber = menuInput.nextInt();

                 account = database.getAccount(accountNumber);

                if (account == null) {
                    System.out.println("Account not found");
                    return;
                }

                while (true) {
                    System.out.print("Enter your Pin number: ");
                    int pinNumber = menuInput.nextInt();

                    if (account.getAccountPin() == pinNumber) {
                        System.out.println("Login successful");
                        getMenuSelection();
                        break;
                    } else {
                        System.out.println("Incorrect Pin number. Please try again.");
                    }
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println(INVALID_INPUT);
                menuInput.next();
            }
        }
    }
}
