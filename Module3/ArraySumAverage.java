import java.util.Scanner;

public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int size = scanner.nextInt();

        int[] values = new int[size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
            sum += values[i];
        }

        double average = size > 0 ? (double) sum / size : 0;
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
        scanner.close();
    }
}
