package com.hrm.genericUtility;

import com.aventstack.extentreports.ExtentTest;


/**
 * This class consist of getter and setter methods for WebdriverUtility and ExtentTest
 * @author daniel
 *
 */
public class ThreadSafe {

	private static ThreadLocal<WebDriverUtility> webdriverUtility= new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> extentTest= new ThreadLocal<>();
	
	
	public static WebDriverUtility getWebdriverUtility()
	{
		return webdriverUtility.get();
	}
	
	public static void setWebdriverUtility(WebDriverUtility swebdriverUtility)
	{
		webdriverUtility.set(swebdriverUtility);
	}
	
	public static ExtentTest getExtentTest()
	{
		return extentTest.get();
    }
	
	public static void setExtentTest(ExtentTest sExtentTest)
	{
		extentTest.set(sExtentTest);
	}
}
