package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HelperUtil 
{
	
//Create a ArrayList method()
public static List<Object> createArrayList()
{
 	List<Object> list=new ArrayList<Object>(); 	
return list;
}

//Create a HashMap method()
public static Map<Object,Object> createHashMap()
{
	Map<Object,Object> map=new HashMap<Object,Object>();
return map;
}


public static void checkString(String inputString) throws CustomException {
if(inputString == null||inputString.isEmpty())
{
throw new CustomException("String can't be empty and null");
}
}

public static void nullCheckStringBuilder(StringBuilder checkStrBuil) throws CustomException{
if(checkStrBuil == null)
{
throw new CustomException("Stringbuilder can't be null");
}
}

public static void nullCheckList(List<Object> checkArray) throws CustomException
{
if(checkArray == null)
{
	throw new CustomException("ArrayList can't be null");
}
}


public static void nullCheckMap(Map<Object,Object> checkMap) throws CustomException
{
if(checkMap == null)
{
	throw new CustomException("Map can't be Null");
}
}

public static void nullCheckFile(Object objFile) throws CustomException
{
if(objFile == null)
{
	throw new CustomException("File can't be null");
}
}

public static void nullCheckObject(Object object) throws CustomException
{
if(object == null)
{
	throw new CustomException("Object can't be null");
}
}
}
