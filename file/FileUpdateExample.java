
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUpdateExample {
    public static void main(String[] args) {
        String filePath = "example.txt";
        String newString = "New String to Insert";
        int insertPosition = 1; // Insert after the first line

        List<String> fileContent = new ArrayList<>();

        // Step 1: Read the file content into a list
        try (FileInputStream fis = new FileInputStream(filePath);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 2: Insert the new string at the desired position
        if (insertPosition >= 0 && insertPosition <= fileContent.size()) {
            fileContent.add(insertPosition, newString);
        } else {
            System.out.println("Invalid insertion position.");
            return;
        }

        // Step 3: Write the modified content back to the file
        try (FileOutputStream fos = new FileOutputStream(filePath);
                PrintWriter writer = new PrintWriter(fos)) {
            for (String str : fileContent) {
                writer.println(str);
            }
            System.out.println("File updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
