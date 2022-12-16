package com.hrm.genericUtility;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class is used for retry failed test scripts
 * @author daniel
 *
 */
public class RetryAnalyserimplimentation implements IRetryAnalyzer {

	int count = 0;
	int retrycount = 2;
	@Override
	public boolean retry(ITestResult result) {
		if(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
	}
}

