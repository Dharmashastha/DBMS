package com.test;

import java.util.Map;

import com.dbms.AccountInfo;
import com.dbms.BankLogic;
import com.dbms.CustomerInfo;


public class BankOutput {
	
	private static InputCenter inputCall=new InputCenter();
	private static BankLogic bankCall= new BankLogic();
	
private void customerDetails() throws CustomException
{
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
		long custId=bankCall.layCall.addNewCustomerId();
		custCall.setCustomerId(custId);
		Map<Long,CustomerInfo> customer=bankCall.addCustomerDetails(custCall,custId);
		System.out.println(customer);
	}	
}

private void accountDetails() throws CustomException
{
	    AccountInfo account= new AccountInfo();
		System.out.println("Enter the customerId:");
		long customerId=inputCall.getLong();
		long accNo=bankCall.layCall.addNewAccountNo();
		account.setAccountNo(accNo);
		account.setBalance(bankCall.layCall.setMinBalance());
		account.setCustomerId(customerId);
		Map<Long,Map<Long,AccountInfo>> dummyMap=bankCall.addAccountDetails(account,customerId,accNo);
		System.out.println(dummyMap);
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

		BankOutput outputCall=new BankOutput();
		//Map<Long,CustomerInfo> mapCall=new HashMap<>();
		
		boolean flag=false;

		
while(!flag)
{
	System.out.println("0.Exit\n1.Add new Customer/Account\n2.Retrieve account details "
			+ "\n3.Retrieve customer details\n4.Check account balance\n5.Deposit amount"
			+ "\n6.Withdraw amount\n7.Change Account status\n8.Map File Append\n9.Retrieve File Data");
	
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
					outputCall.accountDetails();
				} catch (CustomException e) {
					e.printStackTrace();
				}
			}		
		else if(check.contains("No"))
				{
					try {
						outputCall.customerDetails();
					} catch (CustomException e) {
						e.printStackTrace();
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
		AccountInfo dummyObj=bankCall.retrieveAccount(customerId,accountNo);
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
		CustomerInfo dummyObj=bankCall.retrieveCustomer(customerId);
			System.out.println(dummyObj);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		break;
}
case 4:
{	
		System.out.println("Enter the customerId:");
		long customerId=inputCall.getLong();
		System.out.println("Enter the AccountNo:");
		long accountNo=inputCall.getLong();
		try {
			System.out.println(bankCall.checkBalance(customerId,accountNo));
		} catch (CustomException e) {
			e.printStackTrace();
		}
		break;
}
case 5:
{	
		System.out.println("Enter the customerId:");
		long customerId=inputCall.getLong();
		System.out.println("Enter the AccountNo:");
		long accountNo=inputCall.getLong();
		System.out.println("Enter the Deposit");
		double deposit=inputCall.getDouble();
		try {
			System.out.println(bankCall.deposit(customerId,accountNo,deposit));
			
		} catch (CustomException e) {
			e.printStackTrace();
		}
		break;
}		
case 6:
{
		System.out.println("Enter the customerId:");
		long customerId=inputCall.getLong();
		System.out.println("Enter the AccountNo:");
		long accountNo=inputCall.getLong();
		System.out.println("Enter the Withdraw");
		double withdraw=inputCall.getDouble();
	try {
		System.out.println(bankCall.withdraw(customerId,accountNo,withdraw));
	} catch (Exception e) {
		e.printStackTrace();
	}
	break;
}
case 7:
{
		System.out.println("Enter the customerId:");
		long customerId=inputCall.getLong();
		System.out.println("Enter the AccountNo:");
		long accountNo=inputCall.getLong();
		System.out.println("Enter the change status:Yes/No");
		String check=inputCall.getString();
		boolean status=false;
		if(check.contains("Yes"))
		{
			status=true;
		}
		else if(check.contains("No"))
		{
			status=false;
		}
		else
		{
			System.out.println("ENTER THE VALID Yes/No");
		}
		try {
			bankCall.changeStatus(customerId, accountNo,status);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		break;
}
case 8:
{
	try {
		bankCall.writeFileInfo();
		System.out.println("CustomerMap,AccountMap,TempAccMap File Successful Append.");
		}
		catch(CustomException e)
		{
			e.printStackTrace();
		}
		break;
}
case 9:
{	
	try {
		bankCall.readFileInfo();
		System.out.println(bankCall.customerMap);
		System.out.println(bankCall.accountMap);
		System.out.println(bankCall.layCall.customerId);
		System.out.println(bankCall.layCall.accountNo);
		}
		catch(CustomException e)
		{
			e.printStackTrace();
		}
		break;
}
}
}
}
}