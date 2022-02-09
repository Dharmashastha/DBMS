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
	
public void nullCheckMap(long customerId) throws CustomException
{
	if(accountMap.get(customerId) == null)
	{
		throw new CustomException("customerId Invalid");
	}	
}
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
	
	
	Map<Long, AccountInfo> custMap=accountMap.get(customerId);
	
	/*
	 * if(custMap != null) { custMap.put(accNo, account); return accountMap; }
	 * custMap=new HashMap<>(); custMap.put(accNo, account);
	 * accountMap.put(customerId, custMap); return accountMap;
	 */
	if(custMap == null)
	{
		custMap=new HashMap<>();
		accountMap.put(customerId, custMap);
	}
	custMap.put(accNo, account);
	return accountMap;
}
public AccountInfo retrieveAccount(long customerId,long accountNo) throws CustomException
{

	Map<Long,AccountInfo> custMap=accountMap.get(customerId);
	nullCheckMap(customerId);
	AccountInfo check=custMap.get(accountNo);
		
	return check;	
	
//	else
//	{
//	throw new CustomException("AccountId Invalid");
//	}
}
public Object retrieveCustomer(long customerId) throws CustomException
{
	CustomerInfo cusInfo=customerMap.get(customerId);
	if(cusInfo != null)
	{
	return	cusInfo;	
	}
	throw new CustomException("CustomerId Invalid"); 
}

}
