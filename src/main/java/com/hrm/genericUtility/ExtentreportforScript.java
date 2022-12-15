package com.hrm.genericUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentreportforScript {
	public static void main(String[] args) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extent/");
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("Report Name"+ new JavaUtility().getDateTime());
		spark.config().setTheme(Theme.STANDARD);
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Operating System", "Windows 10");
		report.setSystemInfo("Browser name", "Chrome");
		report.setSystemInfo("Browser Verision", "107");
		report.setSystemInfo("Reporter Name", "Daniel");
		
		ExtentTest test1 = report.createTest("test1");
		test1.info("This information from script");
		test1.warning("Warning message");
		test1.fail("Test fail");
		test1.skip("skipped");
		
		
		ExtentTest test2 = report.createTest("test2");
		test2.info("This information from script");
		test2.info("This information from script");
		test2.info("This information from script");
		test2.info("test pass");
		
		ExtentTest test3= report.createTest("test3");
		test3.info("This information from script");
		test3.info("This information from script");
		test3.warning("Warning message");
		test3.info("This information from script");
		test3.info("This information from script");
		test3.info("This information from script");
		test3.info("This information from script");
		
		report.flush();
		
	}
	

}
