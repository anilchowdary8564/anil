package cjit;

import java.sql.Connection;
import java.sql.DriverManager;

public class Example2 {
    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/jdbc"; // Replace 'test_db' with your database name
        String user = "root";                              // Replace with your MySQL username
        String password = "1234";                          // Replace with your MySQL password
        
        try {
            // Establish the connection
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
            
            // Close the connection
            connection.close();
        } catch (Exception e) {
            // Print error details
            e.printStackTrace();
        }
    }
}

