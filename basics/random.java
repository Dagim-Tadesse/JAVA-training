
import java.util.Random;
//import java.util.Scanner;

public class random {
    public static void main(String[] args) {
        double x[] = new double[20];
        Random r = new Random();
        // Scanner s = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            x[i] = r.nextInt(100);
            System.out.println(x[i]);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println((int) (Math.random() * 100) + "%");
        }
    }
}
