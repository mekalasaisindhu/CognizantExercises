import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcTransactionExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:accounts.db";
        try (Connection connection = DriverManager.getConnection(url)) {
            connection.setAutoCommit(false);
            try (PreparedStatement create = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS accounts (id INTEGER PRIMARY KEY, name TEXT, balance REAL)")) {
                create.executeUpdate();
            }
            try (PreparedStatement insert = connection.prepareStatement(
                    "INSERT OR IGNORE INTO accounts (id, name, balance) VALUES (?, ?, ?)");
                 PreparedStatement transferDebit = connection.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?");
                 PreparedStatement transferCredit = connection.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?")) {
                insert.setInt(1, 1);
                insert.setString(2, "Alice");
                insert.setDouble(3, 1000);
                insert.executeUpdate();

                insert.setInt(1, 2);
                insert.setString(2, "Bob");
                insert.setDouble(3, 500);
                insert.executeUpdate();

                double amount = 200;
                transferDebit.setDouble(1, amount);
                transferDebit.setInt(2, 1);
                transferDebit.executeUpdate();

                transferCredit.setDouble(1, amount);
                transferCredit.setInt(2, 2);
                transferCredit.executeUpdate();
            }
            connection.commit();
            System.out.println("Transfer completed successfully.");
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}
