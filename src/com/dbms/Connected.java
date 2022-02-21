package com.dbms;

import java.util.Map;

import com.test.CustomException;

public interface Connected 
{
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
	public void insertCustInfo(String insert,Map<Long,CustomerInfo> custMap) throws CustomException;
	public void insertAccInfo(String insert,Map<Long,Map<Long,AccountInfo>> accMap) throws CustomException;
	public void updatePrepared(String update) throws CustomException;
	public void selectWherePrepared(String customer,String account) throws CustomException;
}