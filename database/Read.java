package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Read {
    public static String[] getCustomerNames() {
        Connection connection = Conn.getConnection();
        ArrayList<String> StudNames = new ArrayList<>();

        if (connection != null) {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT FName FROM student");

                while (rs.next()) {
                    StudNames.add(rs.getString("custName"));
                }

                rs.close();
                stmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Database connection failed.");
        }

        // Convert ArrayList to String array
        return StudNames.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] customers = getCustomerNames();
        System.out.println("Customer Names:");
        for (String name : customers) {
            System.out.println(name);
        }
    }
}
