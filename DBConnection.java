package com.sdj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection()
	{
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/test";
		String user="root";
		
		String  pass="root";
		Connection con =null;
	try
	{
		Class.forName(driver);
		con=DriverManager.getConnection(url,user,pass);
		
	}
	catch(ClassNotFoundException ex)
	{
		ex.printStackTrace();
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();}
	return con;
	}

}
