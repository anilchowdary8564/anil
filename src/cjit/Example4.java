package cjit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example4 {

    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anil", "root", "1234");

            // Step 3: Create a statement
            Statement st = con.createStatement();

            // Step 4: Execute the query
            // Corrected query syntax (assuming the table `amt` has two columns: `id` (int) and `name` (varchar))
            int i = st.executeUpdate("INSERT INTO amt (amtid, amtname) VALUES (1, 'abcd')");

            // Step 5: Print success message
            System.out.println(i + " record(s) inserted successfully");

            // Step 6: Close resources
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }
}
