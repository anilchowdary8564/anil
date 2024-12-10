package cjit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example5 {

    public static void main(String[] args) {
        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anil", "root", "1234");

            // Step 3: Create a statement
            Statement st = con.createStatement();

            // Step 4: Execute the query
            ResultSet rs = st.executeQuery("SELECT * FROM amt");

            // Step 5: Process the ResultSet
            while (rs.next()) {
                int id = rs.getInt("amtid");         // Replace 'id' with the actual column name
                String name = rs.getString("amtname"); // Replace 'name' with the actual column name

                // Print the data
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Step 6: Close resources
            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
