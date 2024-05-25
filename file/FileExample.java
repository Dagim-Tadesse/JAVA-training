
import java.io.*;
//java.io.FileOutputStream
//java.io.PrintWriter
//java.io.FileInputStream
//java.io.BufferedReader
//java.io.InputStreamReader
//java.io.IOException

public class FileExample {
    public static void main(String[] args) {
        String[] stringsToWrite = { "Hello", "World", "Java" };
        String[] stringsRead = new String[3];

        // Writing to the file
        try (FileOutputStream fos = new FileOutputStream("Java/file/example1.txt");
                PrintWriter writer = new PrintWriter(fos)) {
            for (String str : stringsToWrite) {
                writer.println(str);
            }
            System.out.println("Strings written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading from the file
        try (FileInputStream fis = new FileInputStream("Java/file/example1.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            for (int i = 0; i < stringsRead.length; i++) {
                stringsRead[i] = reader.readLine();
            }
            System.out.println("Strings read from the file:");
            for (String str : stringsRead) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
