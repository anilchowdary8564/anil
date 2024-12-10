package cjit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AnotherEx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//load the driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","1234");
		Statement st=con.createStatement();
		int i=st.executeUpdate("insert into anil1 values (1,'gopi','anil@13','1234444')");
		System.out.println(i+"records inserted");
		st.close();
		con.close();

	}

	
}
