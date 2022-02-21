package com.dbms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.test.CustomException;
import com.test.InputCenter;

public class BankQuery implements Connected
{

	public long customerId=100000;
	public long accountNo=20000;
	
	InputCenter inputCall= new InputCenter(); 
	Storage storeCall=new Storage();

public void createNewTableQuery(String newTable) throws CustomException
	{
		//newTable = "CREATE TABLE CustomerInfo(customerName VARCHAR(30),dob VARCHAR(30),address VARCHAR(30),customerId INT);";
		try(Statement state=ConnectionUtlity.getConnection().createStatement();)
		{
			if(state.execute(newTable))
			{
				System.out.println("Table Created.");
			}			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

/*public void insertValuesQuery() throws CustomException
	{
		
		//String  insertValue= "INSERT INTO Employee VALUES(105,'DHARMA');";
		try(Statement state=ConnectionUtlity.getConnection().createStatement();)
		{
		
			//state.executeUpdate(insertValue);
			//System.out.println("One Row Created.");
			System.out.println("Enter the Insert value Length:");
			int length=inputCall.getInt();
			//inputCall.getString();
			String[] insertArray=new String[length];
			for(int i=0; i <length;i++)
			{
				System.out.println("Enter the Insert Query:");
				insertArray[i]=inputCall.getString();
				state.executeUpdate(insertArray[i]);
			}
			System.out.println(length +" Row Created.");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public void updateQuery() throws CustomException 
	{
		String  update= "UPDATE Employee SET EmployeeName='DHARMASHASTHA S' WHERE EmployeeId=106";
		try(Statement state=ConnectionUtlity.getConnection().createStatement();)
		{
			
			int check=state.executeUpdate(update);
			if(check != 0)
			{
				System.out.println(check+" Row Updated.");
			}
			else
			{
				System.out.println("No data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public void deleteQuery() throws CustomException
	{
		String  delete= "DELETE FROM Employee WHERE EmployeeId=106";
		try(Statement state=ConnectionUtlity.getConnection().createStatement();)
		{
			
			int check=state.executeUpdate(delete);
			if(check != 0)
			{
				System.out.println(check+" Row Deleted.");
			}
			else
			{
				System.out.println("No data");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public void selectQuery() throws CustomException
	{
		String  select= "SELECT EmployeeId FROM Employee WHERE EmployeeName='dharma'";
		try(Statement state=ConnectionUtlity.getConnection().createStatement();
				ResultSet rs= state.executeQuery(select);)
		{
			if(rs.next())
			{
				System.out.println(rs.getInt(1));
				//System.out.println(rs.getString(2));
				System.out.println("Rows in set.");
			}
			else
			{
				System.out.println("No Data");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

public void insertCustInfo(String insert,Map<Long,CustomerInfo> custMap) throws CustomException
	{
		//String insert="INSERT INTO Employee VALUES(?,?)";
		try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(insert);)
			{			
				int length = 0;
				
				System.out.println(custMap);
				Iterator<Long> custId=custMap.keySet().iterator();
				CustomerInfo custCall=custMap.get(custId);
				System.out.println(custId.toString());
				while(custId.hasNext())
				{
					
					String custName=custCall.getCustomerName();
					String dob=custCall.getDob();
					String address=custCall.getAddress();
					long   customerId=custCall.getCustomerId();
					state.setString(1, custName);
					state.setString(2, dob);
					state.setString(3, address);
					state.setLong(4, customerId);
					state.executeUpdate();
					length++;
				}
				System.out.println(length +" Row Created.");	
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

public void insertAccInfo(String insert,Map<Long,Map<Long,AccountInfo>> accMap) throws CustomException
{
	//String insert="INSERT INTO Employee VALUES(?,?)";
	try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(insert);)
		{			
			int length = 0;
			
			Iterator<Long> custId=accMap.keySet().iterator();
			
			while(custId.hasNext())
			{
				Map<Long, AccountInfo> accCall=accMap.get(custId);
				Iterator<Long> accNo=accCall.keySet().iterator();
				
				while(accNo.hasNext())
				{
					AccountInfo accountCall=accCall.get(accNo);
					long    accountNo=accountCall.getAccountNo();
					double  balance=accountCall.getBalance();
					long    customerId=accountCall.getCustomerId();
					boolean status=accountCall.isStatus();
					state.setLong(1, accountNo);
					state.setDouble(2, balance);
					state.setLong(3, customerId);
					state.setBoolean(4, status);
				}
				state.executeUpdate();
				length++;
			}
			System.out.println(length +" Row Created.");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
}

public void updatePrepared(String update) throws CustomException 
	{
		//String update= "UPDATE Employee SET EmployeeName=? WHERE EmployeeId=?";
		try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(update);)
		{
			System.out.println("Enter the EmployeeName:");
			String name=inputCall.getString();
			state.setString(1, name);
			System.out.println("Enter the EmployeeId:");
			int id=inputCall.getInt();
			state.setInt(2, id);
			int check=state.executeUpdate();
			if(check != 0)
			{
				System.out.println(check+" Row Updated.");
			}
			else
			{
				System.out.println("No data");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
/*public void deletePrepared() throws CustomException 
	{
		String  delete= "DELETE FROM Employee WHERE EmployeeId=?";
		System.out.println("Enter the EmployeeId:");
		int id=inputCall.getInt();
		try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(delete);)
		{
			state.setInt(1, id);
			int check=state.executeUpdate();
			if(check != 0)
			{
				System.out.println(check+" Row Deleted.");
			}
			else
			{
				System.out.println("No data");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public void selectPrepared() throws CustomException
	{
		String  select= "SELECT *FROM Employee";
		try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(select);
				ResultSet rs= state.executeQuery();)
		{
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
			System.out.println("Rows in set.");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

public void selectWherePrepared(String  customer,String account) throws CustomException
	{
		//String  select= "SELECT EmployeeName FROM Employee WHERE EmployeeId=105";
		
		Map<Long,CustomerInfo> custMap=new HashMap<Long, CustomerInfo>();
	
		Map<Long, Map<Long, AccountInfo>> accMap=new HashMap<Long, Map<Long,AccountInfo>>();
		
		Map<Long,AccountInfo> tempMap;
		
		try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(customer);)
		{
			try(ResultSet rs= state.executeQuery();)
			{
				CustomerInfo custCall=new CustomerInfo();
				String custName=rs.getString(1);
				String dob=rs.getString(2);
				String address=rs.getString(3);
				long custId=rs.getLong(4);
				customerId=custId;
				custCall.setCustomerName(custName);
				custCall.setDob(dob);
				custCall.setAddress(address);
				custCall.setCustomerId(custId);
				custMap.put(custId, custCall);
			}
		}
			catch (SQLException e) {
			e.printStackTrace();
		}
		
		try(PreparedStatement stateAcc=ConnectionUtlity.getConnection().prepareStatement(account);)
		{
			try(ResultSet rs= stateAcc.executeQuery();)
			{
				AccountInfo accCall=new AccountInfo();
				long accNo=rs.getLong(1);
				double balance=rs.getDouble(2);
				long custId=rs.getLong(3);
				boolean status=rs.getBoolean(4);
				accCall.setAccountNo(accNo);
				accCall.setBalance(balance);
				accCall.setCustomerId(custId);
				accCall.setStatus(status);
				accountNo=accNo;
				tempMap=accMap.get(custId);
				
				if(tempMap == null)
				{
					tempMap=new HashMap<>();
					accMap.put(custId, tempMap);
				}
				tempMap.put(accNo, accCall);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		storeCall.cacheFile(custMap, accMap);
}


@Override
public long addNewCustomerId() {
	return 0;
}

@Override
public long addNewAccountNo() {
	return 0;
}

@Override
public double setMinBalance() throws CustomException {
	return 0;
}

@Override
public Map<Long, CustomerInfo> writeCustomerFile(Map<Long, CustomerInfo> custMap,
		Map<Long, Map<Long, AccountInfo>> accMap) throws CustomException {
	return null;
}

@Override
public Map<Long, Map<Long, AccountInfo>> writeAccountFile(Map<Long, CustomerInfo> custMap,
		Map<Long, Map<Long, AccountInfo>> accMap) throws CustomException {
	return null;
}

@Override
public Map<Long, CustomerInfo> getCustomerFile() throws CustomException {
	return null;
}

@Override
public Map<Long, Map<Long, AccountInfo>> getAccountFile() throws CustomException {
	return null;
}

@Override
public long getCustomerIdFile() throws CustomException {
	return 0;
}

@Override
public long getAccountNoFile() throws CustomException {
	return 0;
}
}
