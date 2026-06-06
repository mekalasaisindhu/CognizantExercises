import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student ID and name (blank name to stop):");
        while (true) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.isBlank()) {
                break;
            }
            students.put(id, name);
        }

        System.out.print("Enter an ID to look up: ");
        int lookupId = scanner.nextInt();
        System.out.println("Name: " + students.getOrDefault(lookupId, "Not found"));
        scanner.close();
    }
}
