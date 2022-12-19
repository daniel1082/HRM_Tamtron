 package com.hrm.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains java reusable methods
 * @author daniel
 *
 */
public class JavaUtility {
	/**
	 * This method is used to convert String into other datatypes
	 */
	
public Object StringToAnyDatatype(String s, String strategy) { 
	Object convertedData=null;
	if(strategy.equals("int"))
	{
		convertedData=Integer.parseInt(s);
	}
	else if(strategy.equals("long"))
	{
		convertedData=Long.parseLong(s);
	}
		
	return convertedData;
}

/**
 * This method is used to generate random number
 * @param 


 * @return
 */
public int getRandomNumber(int limit) {
	int randomNumber=new Random().nextInt(limit);
	return randomNumber;
}

/**
 * This method is used to get the system date and time in "dd_MM_YYYY_HH_mm_sss"
 * @return
 */
public String getDateTime()
{
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_YYYY_HH_mm_sss");
	String d= sdf.format(date);
	return d;
}
}
