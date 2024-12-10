package cjit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Example3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anil","root" , "1234");
Statement st=con.createStatement();
st.executeUpdate("create table amt (amtid int,amtname varchar(12))");
System.out.println("Table created succesfully");
st.close();
con.close();

	}

}
