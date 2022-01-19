package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DbmsOutput {

Scanner scan=new Scanner(System.in);	
final String dbUrl = "jdbc:mysql://localhost:3306/zoho"; 	
final String user= "root";
final String password= "root@123";


public void createNewTableQuery()
{
	String newTable = "CREATE TABLE Employee(EmployeeId INT,EmployeeName VARCHAR(30));";
	try(Connection connect = DriverManager.getConnection(dbUrl,user,password);
		Statement state=connect.createStatement();)
		
	{
		if(connect != null)
		{
			System.out.println("Connected");
		}
		
		if(state.execute(newTable))
		{
			System.out.println("Table Created.");
		}
		else
		{
			System.out.println("Table Already Created.");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public void insertValuesQuery()
{
	
	//String  insertValue= "INSERT INTO Employee VALUES(105,'DHARMA');";
	try(Connection connect = DriverManager.getConnection(dbUrl,user,password);
		Statement state=connect.createStatement();)
	{
		if(connect != null)
		{
			System.out.println("Connected");
		}
		//state.executeUpdate(insertValue);
		//System.out.println("One Row Created.");
		System.out.println("Enter the Insert value Length:");
		int length=scan.nextInt();
		scan.nextLine();
		String[] insertArray=new String[length];
		for(int i=0; i <length;i++)
		{
			System.out.println("Enter the Insert Query:");
			insertArray[i]=scan.nextLine();
			state.executeUpdate(insertArray[i]);
		}
		System.out.println(length +" Row Created.");	
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void updateQuery() 
{
	String  update= "UPDATE Employee SET EmployeeName='DHARMASHASTHA' WHERE EmployeeId=105";
	try(Connection connect = DriverManager.getConnection(dbUrl,user,password);
		Statement state=connect.createStatement();)
	{
		if(connect != null)
		{
			System.out.println("Connected");
		}
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

public void deleteQuery()
{
	String  delete= "DELETE FROM Employee WHERE EmployeeId=105";
	try(Connection connect = DriverManager.getConnection(dbUrl,user,password);
		Statement state=connect.createStatement();)
	{
		if(connect != null)
		{
			System.out.println("Connected");
		}
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

public void selectQuery()
{
	String  select= "SELECT EmployeeId FROM Employee WHERE EmployeeName='siva'";
	try(Connection connect = DriverManager.getConnection(dbUrl,user,password);
		Statement state=connect.createStatement();)
	{
		if(connect != null)
		{
			System.out.println("Connected");
		}
		ResultSet rs= state.executeQuery(select);
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

public void insertPrepared()
{
	String insert="INSERT INTO Employee VALUES(?,?)";
	try(Connection connect = DriverManager.getConnection(dbUrl,user,password);
			PreparedStatement state=connect.prepareStatement(insert);)
		{
			if(connect != null)
			{
				System.out.println("Connected");
			}
			System.out.println("Enter the Insert value Length:");
			int length=scan.nextInt();
			scan.nextLine();
			for(int i=0; i <length;i++)
			{
				System.out.println("Enter the EmployeeId:");
				int id=scan.nextInt();
				scan.nextLine();
				state.setInt(1, id);
				System.out.println("Enter the EmployeeName:");
				String name=scan.nextLine();
				state.setString(2, name);
				state.executeUpdate();
			}
			System.out.println(length +" Row Created.");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
}

public void updatePrepared() 
{
	String  update= "UPDATE Employee SET EmployeeName=? WHERE EmployeeId=?";
	try(Connection connect = DriverManager.getConnection(dbUrl,user,password);
		PreparedStatement state=connect.prepareStatement(update);)
	{
		if(connect != null)
		{
			System.out.println("Connected");
		}
		System.out.println("Enter the EmployeeName:");
		String name=scan.nextLine();
		state.setString(1, name);
		System.out.println("Enter the EmployeeId:");
		int id=scan.nextInt();
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

public void deletePrepared() 
{
	String  delete= "DELETE FROM Employee WHERE EmployeeId=?";
	try(Connection connect = DriverManager.getConnection(dbUrl,user,password);
		PreparedStatement state=connect.prepareStatement(delete);)
	{
		if(connect != null)
		{
			System.out.println("Connected");
		}
		System.out.println("Enter the EmployeeId:");
		int id=scan.nextInt();
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

public void selectPrepared()
{
	String  select= "SELECT *FROM Employee";
	try(Connection connect = DriverManager.getConnection(dbUrl,user,password);
		PreparedStatement state=connect.prepareStatement(select);)
	{
		if(connect != null)
		{
			System.out.println("Connected");
		}
		ResultSet rs= state.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		System.out.println("Rows in set.");	
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void selectWherePrepared()
{
	String  select= "SELECT EmployeeName FROM Employee WHERE EmployeeId=?";
	try(Connection connect = DriverManager.getConnection(dbUrl,user,password);
		PreparedStatement state=connect.prepareStatement(select);)
	{
		if(connect != null)
		{
			System.out.println("Connected");
		}
		System.out.println("Enter the EmployeeId:");
		int id=scan.nextInt();
		state.setInt(1, id);
		ResultSet rs= state.executeQuery();
		if(rs.next())
		{
			System.out.println(rs.getString(1));
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


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		DbmsOutput dbmsCall=new DbmsOutput();
		try {Class.forName("com.mysql.cj.jdbc.Driver");} 
		catch (ClassNotFoundException e) {e.printStackTrace();}
		int number = 0;
		System.out.println("Enter Your Choice");
		try 
		{
			number=Integer.parseInt(scan.nextLine());
		}
		catch(Exception e)
		{
			System.out.println("Enter the number only");
			e.printStackTrace();
		}
		
switch (number) 
{
case 1:
		dbmsCall.createNewTableQuery();
		break;
case 2:
		dbmsCall.insertValuesQuery();
		break;
case 3:
		dbmsCall.updateQuery();
		break;
case 4:
		dbmsCall.deleteQuery();
		break;
case 5:
		dbmsCall.selectQuery();
		break;
case 6:
		dbmsCall.insertPrepared();
		break;
case 7:
		dbmsCall.updatePrepared();
		break;
case 8:
		dbmsCall.deletePrepared();
		break;
case 9:
		dbmsCall.selectPrepared();
		break;
case 10:
		dbmsCall.selectWherePrepared();
		break;		
}		
scan.close();
}
}
