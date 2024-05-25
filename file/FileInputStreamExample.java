
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        // Path to the file to read
        String filePath = "Java/file/example.txt";

        try (FileInputStream fis = new FileInputStream(filePath)) {
            int content;

            // Read the file content byte by byte
            while ((content = fis.read()) != -1) {
                // Convert the byte to char and print it
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
