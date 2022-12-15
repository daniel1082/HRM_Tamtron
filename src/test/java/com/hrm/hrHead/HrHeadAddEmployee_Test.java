package com.hrm.hrHead;


import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.hrm.genericUtility.ExcelLibrary;
import com.hrm.genericUtility.IConstantPath;
import com.hrm.genericUtility.PropertyFileKeys;
import com.hrm.genericUtility.PropertyLibrary;
import com.hrm.genericUtility.SheetName;
import com.hrm.genericUtility.WebDriverUtility;
import com.hrm.pomRepository.CommonPage;
import com.hrm.pomRepository.HrHeadEmployeePage;
import com.hrm.pomRepository.LoginPageR;

/**
 * This class is used to create new employee details
 * @author daniel
 *
 */
public class HrHeadAddEmployee_Test {
	
	public static void main(String[] args) throws IOException {
		// creating object for generic
		ExcelLibrary ExcelLibrary=new ExcelLibrary();
		PropertyLibrary PropertyLibrary=new PropertyLibrary();
		WebDriverUtility WebDriverUtility=new WebDriverUtility();

		// loading property file
		String browser = PropertyLibrary.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
				PropertyFileKeys.BROWSER.convertToString());
		String url = PropertyLibrary.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
				PropertyFileKeys.URL.convertToString());
		String password = PropertyLibrary.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
				PropertyFileKeys.PASSWORD.convertToString());
		String emp = PropertyLibrary.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
				PropertyFileKeys.EMPLOYEENAME.convertToString());

		// fetching data from excel
		String username = ExcelLibrary.sfetchValidTestData(IConstantPath.EXCEL_PATH.toString(),
				SheetName.HRHeadEmployee.toString(), 1, "HrHeadAddEmployee", "UserName");

		// make browser generic launch the browser
		WebDriver driver = WebDriverUtility.launchAppliction(browser, 10, url);
		// creating object for object repository
		
		
		
		LoginPageR loginpage =new LoginPageR(driver);
		HrHeadEmployeePage hrheademp = new HrHeadEmployeePage(driver);
		CommonPage commonpage = new CommonPage(driver);
		loginpage.loginAction(username, password);
		WebDriverUtility.acceptAlert();
		commonpage.clickempbutton();
		commonpage.clickaddempbutton();
		hrheademp.searchEmployee(emp);
		hrheademp.validate(emp);
		driver.quit();
		System.out.println("test script executed succeffully");
		ExcelLibrary.sinsertDataToExcel(2, 3, IConstantPath.EXCEL_PATH.toString(), SheetName.HRHeadEmployee.toString(), "pass");
	}
	
}
