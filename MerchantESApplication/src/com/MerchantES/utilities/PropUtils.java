package com.MerchantES.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * The methods in this class read the data(key) from external files(data.properties) and return the value
 * @return {String} value
 */
public class PropUtils {
	
	public static String getValueUsingKey(String fileDetails,String key) throws IOException
	{
		FileInputStream file=new FileInputStream(fileDetails);
		Properties prop=new Properties();
		prop.load(file); 
     	String value=prop.getProperty(key);		
		return value;
	}

}
