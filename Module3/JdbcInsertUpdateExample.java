import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcInsertUpdateExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:students.db";
        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT)");
            }

            try (PreparedStatement insert = connection.prepareStatement("INSERT INTO students (name) VALUES (?)")) {
                insert.setString(1, "Charlie");
                insert.executeUpdate();
            }

            try (PreparedStatement update = connection.prepareStatement("UPDATE students SET name = ? WHERE id = ?")) {
                update.setString(1, "Charlie Updated");
                update.setInt(2, 1);
                update.executeUpdate();
            }

            System.out.println("Insert and update completed.");
        } catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
