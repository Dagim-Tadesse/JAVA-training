
// Name: Yeabsera Mesganaw
// ID: 1387/15
// Section: E
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        for (int r = 1; r <= num; ++r) {
            int j;
            for (j = num - r; j > 0; --j) {
                System.out.print(" ");
            }

            for (j = r; j > 0; --j) {
                System.out.print(j);
            }

            for (j = 2; j <= r; ++j) {
                System.out.print("" + j);
            }

            System.out.println();
        }

    }
}
