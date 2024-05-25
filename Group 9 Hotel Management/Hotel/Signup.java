package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Signup {
    public static void addCustomer(String custName) {
        
        Connection connection = Conn.getConnection(); // ✅ Correct


        if (connection != null) {
            try {
                // SQL query to insert customer data
                String sql = "INSERT INTO customer (custName) VALUES (?)";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, custName);

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Customer added successfully!");
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
        System.out.print("Enter customer name: ");
        String custName = scanner.nextLine();

        addCustomer(custName);
        scanner.close();
    }
}
