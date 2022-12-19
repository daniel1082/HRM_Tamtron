package com.hrm.hrOfficer;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genericUtility.BaseClass;
import com.hrm.genericUtility.IConstantPath;
import com.hrm.genericUtility.PropertyFileKeys;
import com.hrm.genericUtility.SheetName;


@Listeners(com.hrm.genericUtility.ListnersImplimentation.class)

public class HrOfficerAddEmployee extends BaseClass {

	@Test
	public void addEmplyeeTest() throws InterruptedException, EncryptedDocumentException, IOException {
		

		webdriver.acceptAlert();

		compg.clickForEmpDetails();

		compg.addEmployee();
		
			// Fetching data from property file
			String compId = prop.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
					PropertyFileKeys.COMPID.convertToString());
			String lastName = prop.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
					PropertyFileKeys.LASTNAME.convertToString());
			String middleName = prop.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
					PropertyFileKeys.MIDDLENAME.convertToString());
			String branchDt = prop.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
					PropertyFileKeys.BRANCHDATE.convertToString());
			String branchRecentDt = prop.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
					PropertyFileKeys.RECENTBRANCHDATE.convertToString());

			// Fetching data from excel file
			String firstName = excel.fetchValidTestData(IConstantPath.EXCEL_PATH.toString(),
					SheetName.EMPLOYEEDETAILS.toString(), 1,
					"CreateEmployeeTest", "FirstName");
			String empPosition = excel.fetchTestData(IConstantPath.EXCEL_PATH,
					SheetName.EMPLOYEECONTACT.toString(), 2, 1);
			String contact = excel.fetchTestData(IConstantPath.EXCEL_PATH, SheetName.EMPLOYEECONTACT.toString(),2, 2);
			String empSSS = excel.fetchTestData(IConstantPath.EXCEL_PATH, SheetName.EMPLOYEECONTACT.toString(),2, 3);
			String empTin = excel.fetchTestData(IConstantPath.EXCEL_PATH, SheetName.EMPLOYEECONTACT.toString(),2, 4);
			String pageBig = excel.fetchTestData(IConstantPath.EXCEL_PATH, SheetName.EMPLOYEECONTACT.toString(),2, 5);
			String empgsis = excel.fetchTestData(IConstantPath.EXCEL_PATH, SheetName.EMPLOYEECONTACT.toString(),2, 6);

			// external test data
			String hrmFile = webdriver.externalFiles(IConstantPath.TESTFILE_PATH);
			String hrmImage = webdriver.externalFiles(IConstantPath.TESTIMAGE_PATH);

			// creating new employee
			
	
				empdetail.creatEmployee(compId, firstName, lastName, middleName, branchDt, branchRecentDt);
				WebElement deptdrop = empdetail.deptEle();
				WebElement branchdrop = empdetail.branchEle();
				webdriver.handleDropdown(deptdrop, 2);
				webdriver.handleDropdown(branchdrop, 2);
				empdetail.sendDetails(empPosition, contact, empSSS, empTin, pageBig, empgsis);
				WebElement file = empdetail.fileLoading();
				WebElement img = empdetail.imgLoading();
				String filepath = webdriver.externalFiles(hrmFile);
				String imgpath = webdriver.externalFiles(hrmImage);		
				file.sendKeys(filepath);
				img.sendKeys(imgpath);
				empdetail.submit();
				webdriver.acceptAlert();
				Assert.fail();
				
//				
//				compg.logOut();
				
				
			//empdetail.creatEmployee(compId, firstName, lastName, middleName, branchDt, branchRecentDt, 2, 2,
			//			empPosition, contact, empSSS, empTin, pageBig, empgsis, hrmFile, hrmImage);, 2, 2, empPosition, contact, empSSS, empTin, pageBig, empgsis, hrmFile, hrmImage
		

			//webdriver.acceptAlert(driver);
	}

}
