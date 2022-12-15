package com.hrm.genericUtility;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


/**
 * This class consist of listener interface implementation
 * @author daniel
 *
 */
public class ListnersImplimentation implements ITestListener{
	
	
	
	ExtentReports report;
	ExtentTest test;
	
	

	
	public void onStart(ITestContext result) {
		
	System.out.println(Thread.currentThread().getId()+ " onStart====> test");  //1st it will execute
	
	ExtentSparkReporter spark=new ExtentSparkReporter("./extent/"+new JavaUtility().getDateTime());
	spark.config().setDocumentTitle("Product Details");
	spark.config().setReportName("Produt details execution report");
	spark.config().setTheme(Theme.DARK);
	
	
	report = new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("Operating System", "Windows 10");
	report.setSystemInfo("Browser name", "Chrome");
	report.setSystemInfo("Browser Verision", "107");
	report.setSystemInfo("Reporter Name", "Daniel");
	}
	
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+ " onTestFailedButWithinSuccessPercentage");
	}
	
	
	
	public void onTestFailure(ITestResult result) {
		
		System.out.println(Thread.currentThread().getId()+ " onTestFailure"); // 2nd this will execute
		
		ThreadSafe.getExtentTest().fail(result.getMethod().getMethodName() + " is Failed");
		ThreadSafe.getExtentTest().fail(result.getThrowable()); // get the exception information 
		
		
		String screenshot = ThreadSafe.getWebdriverUtility().getErrorshotsBase64();
		ThreadSafe.getExtentTest().addScreenCaptureFromBase64String(screenshot, result.getMethod().getMethodName());
	}

	
	
	public void onTestStart(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+ " onTestStart");
		test = report.createTest(result.getMethod().getMethodName());
		ThreadSafe.setExtentTest(test);
	}

	
	
	public void onTestSuccess(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+ " onTestSuccess");
		
		ThreadSafe.getExtentTest().pass(result.getMethod().getMethodName()+ " is passed");

	}


	
	public void onTestSkipped(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+ " onTestSkipped");
		
		ThreadSafe.getExtentTest().skip(result.getMethod().getMethodName()+ " is skipped");
		ThreadSafe.getExtentTest().skip(result.getThrowable());
		
		try {
			String screenshot = ThreadSafe.getWebdriverUtility().getErrorshots(result.getMethod().getMethodName());
			ThreadSafe.getExtentTest().addScreenCaptureFromBase64String(screenshot, result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+ " onTestFailedWithTimeout");

	}
	
	public void onFinish(ITestContext result) {
		System.out.println(Thread.currentThread().getId()+ " onFinish====> test");
		
		report.flush();
	}
}
