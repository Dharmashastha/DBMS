package com.dbms;

import java.util.Map;

import com.test.CustomException;

public interface Connected 
{
	static public long customerId=100000;
	static public long accountNo=20000;
	public long addNewCustomerId();
	public long addNewAccountNo();
	public double setMinBalance() throws CustomException;
	public Map<Long,CustomerInfo> writeCustomerFile
	(Map<Long,CustomerInfo> custMap,Map<Long,Map<Long,AccountInfo>> accMap) throws CustomException;
	public Map<Long,Map<Long,AccountInfo>> writeAccountFile
	(Map<Long,CustomerInfo> custMap,Map<Long,Map<Long,AccountInfo>> accMap) throws CustomException;
	public Map<Long,CustomerInfo> getCustomerFile() throws CustomException;
	public Map<Long, Map<Long, AccountInfo>> getAccountFile() throws CustomException;
	public long getCustomerIdFile() throws CustomException;
	public long getAccountNoFile() throws CustomException;
	public void createNewTableQuery(String newTable) throws CustomException;
	public void insertCustInfo(String insert,String custName,String dob,String address,long customerId) throws CustomException;
	public void insertAccInfo(String insert,long accountNo,double balance,long customerId,boolean status) throws CustomException;
	public void updatePrepared(String update) throws CustomException;
	public void selectWherePrepared(String customer,String account) throws CustomException;
}