import java.util.Scanner;

public class test {
    public static void main(String arg[]) {
        int x;
        Scanner input = new Scanner(System.in);
        System.out.println("enter the number: ");
        x = input.nextInt();
        System.out.println("entered number is: " + x);

        input.close();
    }

}
