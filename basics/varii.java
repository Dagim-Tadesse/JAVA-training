
public class varii {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        // ..............
        System.out.println("x == y = " + (x == y));
        System.out.println("x != y = " + (x != y));
        // .........
        if (x < 20) {
            System.out.println("This is if statement");
        }
        if (y < 10) {
            System.out.println("This is if statement");
        } else {
            System.out.println("this is else statement");
        }
        // ''''''''''''''''''''''''''''''
        if (y == 10) {
            System.out.print("Value of X is 10");
        } else if (y == 20) {
            System.out.print("Value of X is 20");
        } else if (y == 30) {
            System.out.print("Value of X is 30");
        } else {
            System.out.print("This is else statement");
        }
    }
}
