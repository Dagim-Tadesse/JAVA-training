
import java.util.Scanner; // so that I can use Scanner

public class ssscanner {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("How old are you? "); // prompt
        int age = console.nextInt();
        console.nextLine();// to consume the new line created after nextInt(),, so to not mess up with the
                           // next 'nextLine()'
        System.out.println("You'll be 30 in " + (30 - age) + " years.");
        // ''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
        // Scanner input = new Scanner(System.in); changing scanner might help also for
        // nextLine()

        System.out.print("What is your name? ");
        String name;
        name = console.nextLine(); // make it input.nextLine(), if you went with changing the scanner
        System.out.println("Hello there " + name + ", nice to meet you!");
        // ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
        int number1; // first number to add
        int number2; // second number to add
        int sum; // sum of number1 and number2
        System.out.print("Enter first integer: "); // prompt
        number1 = console.nextInt(); // read first number from user
        System.out.print("Enter second integer: "); // prompt
        number2 = console.nextInt(); // read second number from user
        sum = number1 + number2; // add numbers
        System.out.println("Sum is " + sum);
        // ,,,,,,,,,,,,,,,,,,,,,,
        for (int i = 0; i < 3; i++) {
            for (int j = 2; j < 4; j++) {
                System.out.println(i + " " + j);
            }
        }
    }
}
