import java.util.*;

public class HelloName {
    // String name;

    public static void helloName() {
        String name;
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        System.out.println("Hello " + name);
    }

    public static void main(String args[]) {
        System.out.print("What is your name? ");
        helloName();
        Random r = new Random();
        System.out.println(r.nextInt(100));
    }
}
