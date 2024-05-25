
import java.util.Scanner;

public class counter {
    public static void main(String[] args) {
        int y = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("input sentence:");
        String words = input.nextLine();
        int s = words.length();
        for (int i = 0; i < s; i++) {
            String x = words.substring(i, i + 1);
            if (x.equals(" ")) {
                y++;
            } else if (i + 1 == s) {
                y++;

            }
        }
        System.out.println("the number of words is:" + y);
    }
}
