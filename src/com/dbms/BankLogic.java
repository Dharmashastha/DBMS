package com.dbms;


import java.util.HashMap;
import java.util.Map;

import com.test.CustomException;
import com.test.HelperUtil;
import com.test.InputCenter;
import com.test.PersistantLayer;

public class BankLogic {
	
	public PersistantLayer layCall=new PersistantLayer();
	InputCenter inputCall=new InputCenter();
	Storage storageCall=new Storage();
	
	//AccountInfo acInfo;
	
	//public long customerId=100000;
	//public long accountNo=20000;

	public Map<Long,CustomerInfo> customerMap=new HashMap<>();
	public Map<Long,Map<Long,AccountInfo>> accountMap=new HashMap<>();
	
private void nullCheckAccMap(long customerId) throws CustomException
{
	if(accountMap.get(customerId) == null)
	{
		throw new CustomException("customerId Invalid");
	}	
}

private void nullCheckCusMap(long customerId) throws CustomException
{
	if(customerMap.get(customerId) == null)
	{
		throw new CustomException("customerId Invalid");
	}
}


public Map<Long,CustomerInfo> addCustomerDetails(CustomerInfo CustObj,long custId) throws CustomException
{
		
		HelperUtil.nullCheckObject(CustObj);
		//customerId=addNewCustomerId();
		customerMap.put(custId,CustObj);
return customerMap;
}

public Map<Long,Map<Long,AccountInfo>> addAccountDetails(AccountInfo account,long customerId,long accNo) throws CustomException
{
	
	Map<Long, AccountInfo> custMap=accountMap.get(customerId);
	nullCheckCusMap(customerId);
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
	nullCheckAccMap(customerId);
	Map<Long,AccountInfo> custMap=accountMap.get(customerId);
	//System.out.println("AccountMap: "+accountMap+" customerId: "+customerId);
	AccountInfo check=custMap.get(accountNo);
	HelperUtil.nullCheckObject(check);	
	return check;	
	
//	else
//	{
//	throw new CustomException("AccountId Invalid");
//	}
}

public CustomerInfo retrieveCustomer(long customerId) throws CustomException
{
	CustomerInfo cusInfo=customerMap.get(customerId);
	if(cusInfo != null)
	{
	return	cusInfo;	
	}
	throw new CustomException("CustomerId Invalid"); 
}

public double checkBalance(long customerId,long accountNo) throws CustomException
{
	Map<Long,AccountInfo> custMap=accountMap.get(customerId);
	nullCheckAccMap(customerId);
	AccountInfo acInfo = custMap.get(accountNo);
	HelperUtil.nullCheckObject(acInfo);
	acInfo.isStatus();
	checkStatus(acInfo);
return acInfo.getBalance();
}

public double deposit(long customerId,long accountNo,double deposit) throws CustomException
{
	nullCheckAccMap(customerId);
	Map<Long,AccountInfo> custMap=accountMap.get(customerId);
	AccountInfo acInfo = custMap.get(accountNo);
	if(deposit > 0)
	{	
	double balance=checkBalance(customerId, accountNo)+deposit;
	acInfo.setBalance(balance);
	return balance;
	}
	throw new CustomException("Deposit Negative Amount"); 
}

public double withdraw(long customerId,long accountNo,double withdraw) throws CustomException
{
	Map<Long,AccountInfo> custMap=accountMap.get(customerId);
	nullCheckAccMap(customerId);
	AccountInfo acInfo = custMap.get(accountNo);
	double balance=checkBalance(customerId, accountNo); 
	if(balance > withdraw)
	{
		balance-=withdraw;
		acInfo.setBalance(balance);
		return balance;
	}
	throw new CustomException("withdraw Invalid Amount");
}

public void checkStatus(AccountInfo acInfo) throws CustomException
{
	boolean status=acInfo.isStatus();
	if(!status) {
		throw new CustomException("Account Inactived");
	}
}

public String changeStatus(long id,long accNumber,boolean newStatus) throws CustomException
{
	nullCheckAccMap(id);
	Map<Long, AccountInfo> accMap=accountMap.get(id);
	AccountInfo acInfo = accMap.get(accNumber);
	boolean status=acInfo.isStatus();
	//checkStatus(acInfo);
	if(status!=newStatus)
	{
		acInfo.setStatus(newStatus);
		return "status changed";
	}
	throw new CustomException("Account already Active/Inactived");
}

public void writeFileInfo() throws CustomException
{
	customerMap=layCall.writeCustomerFile(customerMap, accountMap);
	accountMap=layCall.writeAccountFile(customerMap, accountMap);
	storageCall.cacheFile(customerMap, accountMap);
}

public void readFileInfo() throws CustomException
{
	storageCall.customerMap=layCall.getCustomerFile();
	storageCall.accountMap=layCall.getAccountFile();
	layCall.customerId=layCall.getCustomerIdFile();
	layCall.accountNo=layCall.getAccountNoFile();
	customerMap=storageCall.customerMap;
	accountMap=storageCall.accountMap;
	
}
}
