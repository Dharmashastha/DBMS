package com.test;

import java.util.Scanner;

public class InputCenter {
	
	Scanner inputCall = new Scanner(System.in);

	
public String getString(){
	String stringName="";
try
{
	//System.out.println("Enter the String:");
	stringName=inputCall.nextLine();
	if(stringName ==null||stringName.isEmpty())
		{
			throw new Exception("String can't be empty and null  ");
		}
}
catch(Exception e)
{
	System.out.println(e.getMessage() +"Skipping the string input is prohibited");
}
return stringName; 
}

public int getInt(){
	int number=0;
try{
	//inputCall.nextLine();
	//System.out.println("Enter the Int:");
	String stringNumber=inputCall.nextLine();
	if(stringNumber == null||stringNumber.isEmpty())
		{
			throw new Exception("Int can't be empty and null  ");
		}
	number=Integer.parseInt(stringNumber);
}
catch(Exception e)
{
	System.out.println(e.getMessage() +"Skipping the number input is prohibited");
}
return number;
}

public float getFloat(){
	float number=0.0f;
try{
	//inputCall.nextLine();
	//System.out.println("Enter the Float:");
	String stringNumber=inputCall.nextLine();
	if(stringNumber == null||stringNumber.isEmpty())
		{
			throw new Exception("Float can't be empty and null  ");
		}
	number=Float.parseFloat(stringNumber);
}
catch(Exception e)
{
	System.out.println(e.getMessage() +"Skipping the number input is prohibited");
}
return number;
}

public double getDouble(){
	double number=0.00;
	//inputCall.nextLine();
try{
	//System.out.println("Enter the Double:");
	String stringNumber=inputCall.nextLine();
	if(stringNumber == null||stringNumber.isEmpty())
		{
			throw new Exception("Double can't be empty and null  ");
		}
	number=Double.parseDouble(stringNumber);
}
catch(Exception e)
{
	System.out.println(e.getMessage() +"Skipping the number input is prohibited");
}
return number;
}

public long getLong(){
	long number=000000;
	//inputCall.nextLine();
try{
	//System.out.println("Enter the Double:");
	String stringNumber=inputCall.nextLine();
	if(stringNumber == null||stringNumber.isEmpty())
		{
			throw new Exception("Long can't be empty and null  ");
		}
	number=Long.parseLong(stringNumber);
}
catch(Exception e)
{
	System.out.println(e.getMessage() +"Skipping the number input is prohibited");
}
return number;
}

public char getChar(){
	char character=' ';
try{
	//System.out.println("Enter the Character:");
	String stringCharacter=inputCall.nextLine();
	if(stringCharacter == null||stringCharacter.isEmpty())
		{
			throw new Exception("Chararacter can't be empty and null  ");
		}
	character=stringCharacter.charAt(0);
}
catch(Exception e)
{
	System.out.println(e.getMessage() +"Skipping the character input is prohibited");
}
return character;
}

public  int getChoice(){
	int choice=0;
try{
	String stringNumber=inputCall.nextLine();
	if(stringNumber.isEmpty()||stringNumber == null)
		{
			throw new Exception("Number can't be empty and null  ");
		}
	choice=Integer.parseInt(stringNumber);
	//inputCall.nextLine();
}
catch(Exception e)
{
	System.out.println(e.getMessage() +"Skipping the number input is prohibited");
}
return choice;
}

public Object[] getStringArray(){
	System.out.println("how many string you want:");
	int num=inputCall.nextInt();	
	inputCall.nextLine();
	System.out.println("Enter the String:");
	Object [] strArray=new Object[num];
	for(int i=0;i < num;i++)
		{
			strArray[i]=inputCall.nextLine();
		}
return strArray;
}

public Object[] getIntArray(){
	System.out.println("how many Int you want:");
	int num=inputCall.nextInt();	
	System.out.println("Enter the Int:");
	Object [] intArray=new Object[num];
	for(int i=0;i<num;i++)
		{
			intArray[i]=inputCall.nextInt();
		}
	//inputCall.nextLine();
return intArray;
}	
}
