package com.dbms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.test.CustomException;
import com.test.InputCenter;

public class DbmsQuery
{

	InputCenter inputCall= new InputCenter(); 
	

public void createNewTableQuery() throws CustomException
	{
		String newTable = "CREATE TABLE Employee(EmployeeId INT,EmployeeName VARCHAR(30));";
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

public void insertValuesQuery() throws CustomException
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
	}

public void insertPrepared() throws CustomException
	{
		String insert="INSERT INTO Employee VALUES(?,?)";
		try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(insert);)
			{			
				
				System.out.println("Enter the Insert value Length:");
				int length=inputCall.getInt();
				//inputCall.getString();
				for(int i=0; i <length;i++)
				{
					System.out.println("Enter the EmployeeId:");
					int id=inputCall.getInt();
					//inputCall.getString();
					state.setInt(1, id);
					System.out.println("Enter the EmployeeName:");
					String name=inputCall.getString();
					state.setString(2, name);
					state.executeUpdate();
				}
				System.out.println(length +" Row Created.");	
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

public void updatePrepared() throws CustomException 
	{
		String  update= "UPDATE Employee SET EmployeeName=? WHERE EmployeeId=?";
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
	
public void deletePrepared() throws CustomException 
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
	}

public void selectWherePrepared() throws CustomException
	{
		String  select= "SELECT EmployeeName FROM Employee WHERE EmployeeId=105";
		
		
		try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(select);)
		{
			System.out.println("Enter the EmployeeId:");
			int id=inputCall.getInt();
			state.setInt(1, id);
			try(ResultSet rs= state.executeQuery();)
			{
			if(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println("Rows in set.");
			}
			else
			{
				System.out.println("No Data");
			}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
