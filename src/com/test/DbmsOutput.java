package com.test;

import com.dbms.ConnectionUtlity;
import com.dbms.DbmsQuery;

public class DbmsOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		InputCenter inputCall=new InputCenter();
		DbmsQuery dbmsCall=new DbmsQuery();
		//try {Class.forName("com.mysql.cj.jdbc.Driver");} 
		//catch (ClassNotFoundException e) {e.printStackTrace();}
		
		System.out.println("Enter Your Choice");
		int choice = inputCall.getChoice();
		
switch (choice) 
{
case 1:
	try {
		dbmsCall.createNewTableQuery();
	} catch (CustomException e) {
		e.printStackTrace();
	}
		break;
case 2:
	/*
	 * try { dbmsCall.insertValuesQuery(); } catch (CustomException e) {
	 * e.printStackTrace(); }
	 */
		break;
case 3:
	/*
	 * try { dbmsCall.updateQuery(); } catch (CustomException e) {
	 * e.printStackTrace(); }
	 */
		break;
case 4:
	/*
	 * try { dbmsCall.deleteQuery(); } catch (CustomException e) {
	 * e.printStackTrace(); }
	 */
		break;
case 5:
	/*
	 * try { dbmsCall.selectQuery(); } catch (CustomException e) {
	 * e.printStackTrace(); }
	 */
		break;
case 6:
	try {
		dbmsCall.insertPrepared();
	} catch (CustomException e) {
		e.printStackTrace();
	}
		break;
case 7:
	try {
		dbmsCall.updatePrepared();
	} catch (CustomException e) {
		e.printStackTrace();
	}
		break;
case 8:
	try {
		dbmsCall.deletePrepared();
	} catch (CustomException e) {
		e.printStackTrace();
	}
	finally
	{
		ConnectionUtlity.closeConnection();
	}
		break;
case 9:
	try {
		dbmsCall.selectPrepared();
	} catch (CustomException e) {
		e.printStackTrace();
	}
		break;
case 10:
	try {
		dbmsCall.selectWherePrepared();
	} catch (CustomException e) {
		e.printStackTrace();
	}
		break;					
case 11:
		ConnectionUtlity.closeConnection();
		break;
}		
}
}