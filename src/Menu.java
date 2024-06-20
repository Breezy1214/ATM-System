import java.util.Scanner;

public class Menu {
    static Database database;
    Scanner menuInput = new Scanner(System.in);

    public static void getLogin() {
        database = (Database) FileHandler.loadState("AccountData");

        if (database == null) {
            Account acc1 = new Account(12356797, 12345);
            database = Database.getInstance();
            database.addAccount(acc1);

            System.out.println("Created " + database.getAccount(acc1.getAccountNumber()));
        }

        System.out.println("Welcome to the ATM");
        System.out.println("Enter your Account number: ");
        System.out.println("Enter your Pin number: ");
    }
}
