package com.dbms;

import java.sql.*;

import com.test.CustomException;
import com.test.HelperUtil;

public enum ConnectionUtlity {
		
	CONNECTION;

	private final static String dbUrl = "jdbc:mysql://localhost:3306/zoho"; 	
	private final static String user= "root";
	private final static String password= "Root@123";
	
	private static Connection connect=null;
	
	
public static Connection getConnection() throws CustomException {
	try
	{
		if(connect == null)
		{
			HelperUtil.checkString(dbUrl);
			HelperUtil.checkString(user);
			HelperUtil.checkString(password);
			connect = DriverManager.getConnection(dbUrl, user, password);
			System.out.println("Connected.");
			return connect;
		}
		else
		{
			return connect;
		}
		
		}
	catch(SQLException e)
	{
		e.printStackTrace();
		throw new CustomException("Connection error");
	}
}

public static void closeConnection()
{
	try
	{
		if(connect != null)
		{
		
			connect.close();
		}
	}
	catch(SQLException e) {}
}
}
