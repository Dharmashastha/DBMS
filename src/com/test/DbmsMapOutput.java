package com.test;

import java.util.HashMap;
import java.util.Map;

import com.dbms.AccountInfo;
import com.dbms.BankLogic;


public class DbmsMapOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputCenter inputCall=new InputCenter();
		
		
		
		BankLogic bankCall=new BankLogic();

		boolean flag=false;
		System.out.println("Enter the choice:");
		int choice=inputCall.getChoice();
		Map<Long,Object> mapCall=new HashMap<Long,Object>();
		Map<Long,Map<Long,Object>> map=new HashMap<Long,Map<Long,Object>>();
while(!flag)
{
switch(choice)
{
case 0:
		flag=true;
		break;
case 1:
{
		System.out.println("You have Already Account:Yes/No");
		String checkAccount=inputCall.getString();
		if(checkAccount.contains("Yes"))
			{
				AccountInfo account= new AccountInfo();
				Map<Long,Object> customer=bankCall.addCustomberDetails();
				System.out.println("Enter the customerId:");
				long customerId=inputCall.getLong();
				System.out.println(customer);
				System.out.println(bankCall.addAccountDetails(customerId, account));		
			}	
		else
			{
				System.out.println("ENTER THE VALID Yes/No");
			}
		break;
}
case 2:
{
		
		break;
}
case 3:
		
		break;
}
}
}
}
