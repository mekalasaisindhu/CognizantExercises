import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int secret = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int guess = 0;

        System.out.println("Guess a number between 1 and 100.");
        while (guess != secret) {
            System.out.print("Your guess: ");
            guess = scanner.nextInt();
            if (guess < secret) {
                System.out.println("Too low.");
            } else if (guess > secret) {
                System.out.println("Too high.");
            } else {
                System.out.println("Correct! The number was " + secret + ".");
            }
        }

        scanner.close();
    }
}
