package com.test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.dbms.AccountInfo;
import com.dbms.Connected;
import com.dbms.CustomerInfo;



public class PersistantLayer implements Connected
{

public long customerId=100000;
public long accountNo=20000;

public long addNewCustomerId()
{	
return ++customerId;		
}

public long addNewAccountNo()
{
return ++accountNo;	
}

public double setMinBalance() throws CustomException
{
	AccountInfo account= new AccountInfo();
	HelperUtil.nullCheckFile(account);
	account.setBalance(1000.00);
return 	account.getBalance();
}
	
	
	
public Map<Long,CustomerInfo> writeCustomerFile(Map<Long,CustomerInfo> custMap,Map<Long,Map<Long,AccountInfo>> accMap) throws CustomException
{

	//Map<Long,CustomerInfo> mapCall=new HashMap<>();
	try(FileOutputStream fos=new FileOutputStream("file.txt");	
			ObjectOutputStream oos=new ObjectOutputStream(fos);)
	{
			oos.writeObject(custMap);
			oos.writeObject(accMap);
			oos.writeLong(customerId);
			oos.writeLong(accountNo);
			
	}
	catch(IOException e)
	{
		throw new CustomException(e);
	}
return custMap;	
}


public Map<Long,Map<Long,AccountInfo>> writeAccountFile(Map<Long,CustomerInfo> custMap,Map<Long,Map<Long,AccountInfo>> accMap) throws CustomException
{

	//Map<Long,CustomerInfo> mapCall=new HashMap<>();
	try(FileOutputStream fos=new FileOutputStream("file.txt");	
			ObjectOutputStream oos=new ObjectOutputStream(fos);)
	{
			oos.writeObject(custMap);
			oos.writeObject(accMap);
			oos.writeLong(customerId);
			oos.writeLong(accountNo);
			
	}
	catch(IOException e)
	{
		throw new CustomException(e);
	}
return accMap;	
}

public Map<Long,CustomerInfo> getCustomerFile() throws CustomException
{
	try(FileInputStream fis=new FileInputStream("file.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);)
			{ 	
			return (Map<Long, CustomerInfo>) ois.readObject();
			} 
	catch (IOException | ClassNotFoundException e) {
				throw new CustomException(e);
			}
}

public Map<Long, Map<Long, AccountInfo>> getAccountFile() throws CustomException
{
	try(FileInputStream fis=new FileInputStream("file.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);)
			{ 	
			ois.readObject();
			return (Map<Long, Map<Long, AccountInfo>>) ois.readObject();
			} 
	catch (IOException | ClassNotFoundException e) {
				throw new CustomException(e);
			}
}

public long getCustomerIdFile() throws CustomException
{
	try(FileInputStream fis=new FileInputStream("file.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);)
			{ 
			ois.readObject();
			ois.readObject();
			return ois.readLong();
			} 
	catch (IOException | ClassNotFoundException e) {
				throw new CustomException(e);
			}
}

public long getAccountNoFile() throws CustomException
{
	try(FileInputStream fis=new FileInputStream("file.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);)
			{
			ois.readObject();
			ois.readObject();
			ois.readLong();
			return ois.readLong();
			} 
	catch (IOException | ClassNotFoundException e) {
				throw new CustomException(e);
			}
}

@Override
public void createNewTableQuery(String newTable) throws CustomException {	
}

@Override
public void updatePrepared(String update) throws CustomException {
}

@Override
public void selectWherePrepared(String customer, String account) throws CustomException {
}

@Override
public void insertCustInfo(String insert, String custName, String dob, String address, long customerId)
		throws CustomException {
}

@Override
public void insertAccInfo(String insert, long accountNo, double balance, long customerId, boolean status)
		throws CustomException {
}

}