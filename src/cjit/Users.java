package cjit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Users {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "1234");
		String insertQuery = "INSERT INTO user (name, email,phone) VALUES (?, ?,?)";
		try (PreparedStatement insertStmt = con.prepareStatement(insertQuery)) {
			    insertStmt.setString(1, 'shalini');
	            insertStmt.setString(2, "abcd");
	            insertStmt.setString(3,"12345555")
	            insertStmt.executeUpdate();

		}
	}

}
