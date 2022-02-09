package com.test;


import java.util.Map;

import com.dbms.AccountInfo;
import com.dbms.BankLogic;
import com.dbms.CustomerInfo;


public class BankOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputCenter inputCall=new InputCenter();
	
		BankLogic bankCall=new BankLogic();

		boolean flag=false;

while(!flag)
{
	System.out.println("Enter the choice:");
	int choice=inputCall.getChoice();
switch(choice)
{
case 0:
		flag=true;
		break;
case 1:
{
		System.out.println("Do You have CustomerId:Yes/No");
		String check=inputCall.getString();
		if(check.contains("Yes"))
			{
			try {
				AccountInfo account= new AccountInfo();
				System.out.println("Enter the customerId:");
				long customerId=inputCall.getLong();
				long accNo=bankCall.addNewAccountNo();
				account.setAccountNo(accNo);
				account.setBalance(bankCall.setMinBalance());
				account.setCustomerId(customerId);
				Map<Long,Map<Long,AccountInfo>> dummyMap=bankCall.addAccountDetails(account,customerId,accNo);
				if(dummyMap != null)
				{
					System.out.println(dummyMap);
				}
				else
				{
					System.out.println("CustomerId Invalid");
				}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
					ex.printStackTrace();
				}						
			}		
		else if(check.contains("No"))
				{
			try {
				System.out.println("How many customer's details add list:");
				int length=inputCall.getInt();
				for(int i=1;i <= length;i++)
				{
					CustomerInfo custCall=new CustomerInfo();
					System.out.println(i +" customer details");
					System.out.println("Set CustomerName:");
					custCall.setCustomerName(inputCall.getString());
					System.out.println("Set DateOfBirth:");
					custCall.setDob(inputCall.getString());
					System.out.println("Set Address:");
					custCall.setAddress(inputCall.getString());
					Map<Long,CustomerInfo> customer=bankCall.addCustomerDetails(custCall);
					System.out.println(customer);
				}
				}
			catch(Exception ex)
			{
				System.out.println(ex);
				ex.printStackTrace();
			}
			}
		else
				{
					System.out.println("ENTER THE VALID Yes/No");
				}
		break;
}
case 2:
{
	try {
		System.out.println("Enter the customerId:");
		long customerId=inputCall.getLong();
		System.out.println("Enter the AccountNo:");
		long accountNo=inputCall.getLong();
		Object dummyObj=bankCall.retrieveAccount(customerId,accountNo);
			System.out.println(dummyObj);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		break;
}
case 3:
{	
	try {
		System.out.println("Enter the customerId:");
		long customerId=inputCall.getLong();
		Object dummyObj=bankCall.retrieveCustomer(customerId);
	
			System.out.println(dummyObj);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		break;
}
}
}
}
}
