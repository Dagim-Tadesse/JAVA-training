
import java.io.*;

public class aplab {
    static void p(String x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
        File f1 = new File("example.txt");

        p("File name: " + f1.getName());
        p("Path: " + f1.getPath());
        p("Abs Path: " + f1.getAbsolutePath());
        p("Parent: " + f1.getParent());
        p(f1.exists() ? "exists" : "does not exist");
        p(f1.canWrite() ? "is writeable" : "is not writeable");
        p(f1.canRead() ? "is readable" : "is not readable");
        p("is " + (f1.isDirectory() ? "" : "not " + "a directory"));
        p(f1.isFile() ? "is normal file" : "might be a named pipe");
        p(f1.isAbsolute() ? "is absolute" : "is not absolute");
        p("File last modified: " + f1.lastModified());
        p("File size: " + f1.length() + "Bytes");

        // ------------------read-------------------------
        try (FileInputStream fread = new FileInputStream(f1.getPath())) {
            int word;

            while ((word = fread.read()) != -1) {
                System.out.print((char) word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // -----------------------write-----------------------

        String data = "hellooooo";

        try {

            FileOutputStream outputStream = new FileOutputStream("example.txt");
            outputStream.write(data.getBytes());
            outputStream.close();

            System.out.println("\nData has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
