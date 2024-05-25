
public class array {
    public static void main(String[] args) {
        int N = 9;
        int[] x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = (int) (Math.random() * 100);
            System.out.print(x[i] + " ");
        }
        int[] values = { 9, 15, 18 }; // initializing array
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

    }
}
