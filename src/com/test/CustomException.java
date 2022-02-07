package com.test;

import java.io.IOException;
import java.sql.SQLException;

public class CustomException extends Exception 
{
	
public CustomException(String message)
{
	super(message);
}

public CustomException(IOException error) {
	super(error);
}

public CustomException(SQLException error)
{
	super(error);
}

public CustomException(ClassNotFoundException error)
{
	super(error);
}
}
