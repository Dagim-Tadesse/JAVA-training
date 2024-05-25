package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Signup {
    public static void addCustomer(String Id, String fname, String lname, String gender) {

        Connection connection = Conn.getConnection();

        if (connection != null) {
            try {

                String sql = "INSERT INTO student (StudId,FName,LName,Gender) VALUES (?,?,?,?)";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, Id);
                pstmt.setString(2, fname);
                pstmt.setString(3, lname);
                pstmt.setString(4, gender);

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Student added successfully!");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Database connection failed.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student information: ");
        System.out.print("First name: ");
        String fname = scanner.nextLine();
        System.out.print("Last name: ");
        String lname = scanner.nextLine();
        System.out.print("Student Id: ");
        String Id = scanner.nextLine();
        System.out.print("Gender: ");
        String gender = scanner.nextLine();

        addCustomer(Id, fname, lname, gender);
        scanner.close();
    }
}
