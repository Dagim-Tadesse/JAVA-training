
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        String data = "Hello, World!jjjjjjjjjjjjjjjjjjjjjjjjjj";

        try {
            // Create a FileOutputStream to write to a file named "example.txt"
            FileOutputStream outputStream = new FileOutputStream("example.txt");

            // Convert the string data to bytes and write them to the file
            outputStream.write(data.getBytes());

            // Close the output stream to release resources
            outputStream.close();

            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
