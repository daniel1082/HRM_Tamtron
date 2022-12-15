package com.hrm.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
 * This class contains properties which are reused in scripts
 * @author daniel
 *
 */
public class PropertyLibrary {
	private FileInputStream fis;
	

	/**
	 * This method is used to fetch the data from the property file
	 * @param propertyFilePath
	 * @param key
	 * @param  
	 * @return
	 * @throws IOException 
	 */
	public String getPropertyData(String propertyFilePath, String keys) {
		
			try {
				fis=new FileInputStream(propertyFilePath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		Properties property=new Properties();
		
			try {
				property.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		String value = property.getProperty(keys);
		return value;
	}
}
