import java.io.Serializable;
import java.util.HashMap;

public class Database implements Serializable {
    private static Database instance;
    private final HashMap<Integer, Account> accounts;

    private Database() {
        accounts = new HashMap<>();
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public void addAccount(Account account) {
        try {
            Integer accountNumber = account.getAccountNumber();
            accounts.putIfAbsent(accountNumber, account);
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding account to database: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("accounts is null: " + e.getMessage());
        }
    }

    public Account getAccount(Integer accountNumber) {
        return accounts.get(accountNumber);
    }

}
