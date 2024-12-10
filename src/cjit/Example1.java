package cjit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/shalini"; 
        String user = "root";
        String password = "1234";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement sta = con.createStatement()) {

            String query1 = "CREATE TABLE IF NOT EXISTS orders (" +
                            "id INT PRIMARY KEY, " +
                            "itemName VARCHAR(50), " +
                            "price DECIMAL(10, 2))";
            sta.executeUpdate(query1);

//            String query2 = "INSERT INTO orders (id, itemName, price) " +
//                            "VALUES (4, 'Margherita', 250), " +
//                            "(2, 'Burger', 165), " +
//                            "(3, 'Taco', 175), " +
//                            "(4, 'Pasta', 225)";
//            sta.executeUpdate(query2);

            String query3 = "SELECT * FROM orders"; 
            String query4="SELECT * from akhil";
            ResultSet res = sta.executeQuery(query3);
ResultSet res1=sta.executeQuery(query4);
            System.out.println("ID / Item Name / Price");
          
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}