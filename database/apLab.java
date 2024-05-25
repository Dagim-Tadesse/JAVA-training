package database;

import java.sql.*;

public class apLab {
    public static void main(String[] args) throws Exception {
        String URL = "jdbc:mysql://localhost:3306/users";
        String USER = "root";
        String PASSWORD = "dragondagi";
        String Query = "INSERT INTO student (StudId,FName,LName,Gender) VALUES (ETS0343/15,dagim,tadesse,male)";

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL database successfully!");

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(Query);

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }

    }
}
