package com.dbms;

import java.util.HashMap;
import java.util.Map;

import com.test.InputCenter;

public class BankLogic {
	
	InputCenter inputCall=new InputCenter();
	
	private long customerId=100000;
	private long accuontNo=20000;
	
	long saved=00000;
	
	Map<Long,Object> mapCall=new HashMap<Long,Object>();
	Map<Long,Map<Long,Object>> map=new HashMap<Long,Map<Long,Object>>();
	
public long addNewCustomerId()
{
return ++customerId;		
}

public long addNewAccountNo()
{
return ++accuontNo;	
}
public Map<Long,Object> addCustomberDetails()
{
	System.out.println("How many customer's details add list:");
	int length=inputCall.getInt();
	for(int i=1;i <= length;i++)
	{
		CustomerInfo customer=new CustomerInfo();
		
		System.out.println(i +" customer details");
		
		System.out.println("Set CustomerName:");
		
		customer.setCustomerName(inputCall.getString());
		System.out.println("Set DateOfBirth:");
		customer.setDob(inputCall.getString());
		System.out.println("Set Address:");
		customer.setAddress(inputCall.getString());
		saved=addNewCustomerId();
		mapCall.put(saved,customer);
	}
return mapCall;
}

public Map<Long,Map<Long,Object>> addAccountDetails(long customerId,Object objCall)
{
	if(mapCall.containsKey(customerId))
	{
		map.put(saved, mapCall);
		map.get(saved).put(addNewAccountNo(), objCall);
		return map;
	}
	else
	{
		return null;
	}
	
}

//public Map<Long,Object> newAccountId(Map mapCall,long customerId)
//{
//	if(mapCall.get(customerId) != null )
//	{
//		
//		return mapCall;
//	}
//	else
//	{
//		return null;
//	}
//		
//}
}
