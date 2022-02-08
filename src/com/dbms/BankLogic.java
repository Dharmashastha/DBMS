package com.dbms;

import java.util.HashMap;
import java.util.Map;

import com.test.CustomException;
import com.test.HelperUtil;
import com.test.InputCenter;

public class BankLogic {
	
	InputCenter inputCall=new InputCenter();
	
	private long customerId=100000;
	private long accuontNo=20000;
	
	Map<Long,CustomerInfo> customerMap=new HashMap<>();
	Map<Long,Map<Long,AccountInfo>> accountMap=new HashMap<>();
	Map<Long,AccountInfo> newAccount=new HashMap<>();
	
public long addNewCustomerId()
{
return ++customerId;		
}

public long addNewAccountNo()
{
return ++accuontNo;	
}

public double setMinBalance() throws CustomException
{
	AccountInfo account= new AccountInfo();
	HelperUtil.nullCheckFile(account);
	account.setBalance(1000.00);
return 	account.getBalance();
}

public Map<Long,CustomerInfo> addCustomerDetails(CustomerInfo CustObj) throws CustomException
{
		long custId;
		HelperUtil.nullCheckObject(CustObj);
		custId=addNewCustomerId();
		customerMap.put(custId,CustObj);
return customerMap;
}

public Map<Long,Map<Long,AccountInfo>> addAccountDetails(AccountInfo account,long customerId,long accNo) throws CustomException
{
	
	if(customerMap.get(customerId) != null)
	{
		accountMap.put(customerId, (Map<Long, AccountInfo>) accountMap.get(customerId).put(accNo, account));
		return accountMap;
	}
	return null;
	
}

public Object retrieveAccount(long customerId,long accountNo)
{
	if(accountMap.containsKey(customerId) && accountMap.get(customerId).containsKey(accountNo))
	{
		
		return accountMap.get(customerId).get(accountNo);	
	}
	else
	{
		return "accountNo";
	}
}

public Object retrieveCustomer(long customerId)
{
	CustomerInfo saved=customerMap.get(customerId);
	if(saved != null)
	{
	return	saved;	
	}
	else
	{
		return "customerId";
	}
}

}
