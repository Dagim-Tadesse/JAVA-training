
import java.util.Scanner;

public class add100 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {

            sum += i;
        }
        System.out.println("the sum of the numbers to 100 is:" + sum);
        // ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        int sum1 = 0;

        // Calculate the sum of the digits......
        while (number != 0) {
            sum1 += number % 10;
            number = number / 10;
        }

        System.out.println("Sum of digits: " + sum1);
        // ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

        // Scanner num = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int first = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int last = scanner.nextInt();

        if (first > last) {

            int temp = first;
            first = last;
            last = temp;
        }

        int count = last - first + 1;

        System.out.println("Number of integers between " + first + " and " + last + " is: " + count);
        System.out.println("The integers are: ");
        for (int i = first; i <= last; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
