package cjit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example6 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Load MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a connection to the database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anil", "root", "1234");

        // Create a statement object
        Statement st = con.createStatement();

        // 1. Insert 4 rows of data into the 'amt' table
        String insertQuery1 = "INSERT INTO amt (amtid, amtname) VALUES (1, 'abcd')";
        String insertQuery2 = "INSERT INTO amt (amtid, amtname) VALUES (2, 'efgh')";
        String insertQuery3 = "INSERT INTO amt (amtid, amtname) VALUES (3, 'ijkl')";
        String insertQuery4 = "INSERT INTO amt (amtid, amtname) VALUES (4, 'mnop')";

        
        // Executing the insert queries
        int rowsInserted1 = st.executeUpdate(insertQuery1);
        int rowsInserted2 = st.executeUpdate(insertQuery2);
        int rowsInserted3 = st.executeUpdate(insertQuery3);
        int rowsInserted4 = st.executeUpdate(insertQuery4);

        // Printing how many rows were inserted
        System.out.println(rowsInserted1 + " record(s) inserted");
        System.out.println(rowsInserted2 + " record(s) inserted");
        System.out.println(rowsInserted3 + " record(s) inserted");
        System.out.println(rowsInserted4 + " record(s) inserted");

        // 2. Update a record in the 'amt' table
        String updateQuery = "UPDATE amt SET amtname = 'xyz' WHERE amtid = 2";
        int rowsUpdated = st.executeUpdate(updateQuery);
        System.out.println(rowsUpdated + 
        		" record(s) updated");

        // 3. Delete a record in the 'amt' table
        String deleteQuery = "DELETE FROM amt WHERE amtid = 3";
        int rowsDeleted = st.executeUpdate(deleteQuery);
        System.out.println(rowsDeleted + " record(s) deleted");

        // 4. Retrieve and display all records from the 'amt' table
        String selectQuery = "SELECT * FROM amt";
        ResultSet rs = st.executeQuery(selectQuery);

        // Print the results
        System.out.println("\nAll records in 'amt' table:");
        while (rs.next()) {
            int amtid = rs.getInt("amtid");
            String amtname = rs.getString("amtname");
            System.out.println("amtid: " + amtid + ", amtname: " + amtname);
        }

        // Close the statement, result set, and connection
        rs.close();
        st.close();
        con.close();
    }
}
