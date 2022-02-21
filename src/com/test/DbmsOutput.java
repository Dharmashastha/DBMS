package com.test;

import com.dbms.ConnectionUtlity;
import com.dbms.BankQuery;

public class DbmsOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		InputCenter inputCall=new InputCenter();
		BankQuery bankCall=new BankQuery();
		//try {Class.forName("com.mysql.cj.jdbc.Driver");} 
		//catch (ClassNotFoundException e) {e.printStackTrace();}
		
		System.out.println("Enter Your Choice");
		int choice = inputCall.getChoice();
		
switch (choice) 
{
/*case 1:
	try {
		bankCall.createNewTableQuery();
	} catch (CustomException e) {
		e.printStackTrace();
	}
		break;
case 2:
	
	 * try { bankCall.insertValuesQuery(); } catch (CustomException e) {
	 * e.printStackTrace(); }
	 
		break;
case 3:
	
	 * try { bankCall.updateQuery(); } catch (CustomException e) {
	 * e.printStackTrace(); }
	 
		break;
case 4:
	
	 * try { bankCall.deleteQuery(); } catch (CustomException e) {
	 * e.printStackTrace(); }
	 
		break;
case 5:
	
	 * try { bankCall.selectQuery(); } catch (CustomException e) {
	 * e.printStackTrace(); }
	 
		break;
case 6:
	try {
		bankCall.insertPrepared();
	} catch (CustomException e) {
		e.printStackTrace();
	}
		break;
case 7:
	try {
		bankCall.updatePrepared();
	} catch (CustomException e) {
		e.printStackTrace();
	}
		break;
case 8:
	try {
		bankCall.deletePrepared();
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
		bankCall.selectPrepared();
	} catch (CustomException e) {
		e.printStackTrace();
	}
		break;
case 10:
	try {
		bankCall.selectWherePrepared();
	} catch (CustomException e) {
		e.printStackTrace();
	}
		break;					
case 11:
		ConnectionUtlity.closeConnection();
		break;
}*/		
}
}
}