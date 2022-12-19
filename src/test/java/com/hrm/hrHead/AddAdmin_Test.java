package com.hrm.hrHead;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.hrm.genericUtility.BaseClass;
import com.hrm.genericUtility.IConstantPath;
import com.hrm.genericUtility.SheetName;

public class AddAdmin_Test extends BaseClass{
	
	@Test
	public void addAdminTest() throws EncryptedDocumentException, IOException {
		webdriver.acceptAlert();
		
		compg.clickAdmin();
		compg.clickAddAdmin();
		adminPage.clickAddAdminBtn();
				
		String companyid = excel.fetchTestData(IConstantPath.EXCEL_PATH, SheetName.AdminDetails.toString(),2, 1);
		String firstname = excel.fetchTestData(IConstantPath.EXCEL_PATH, SheetName.AdminDetails.toString(),2, 2);
		String lastname = excel.fetchTestData(IConstantPath.EXCEL_PATH, SheetName.AdminDetails.toString(),2, 3);
		String middlename = excel.fetchTestData(IConstantPath.EXCEL_PATH, SheetName.AdminDetails.toString(),2, 4);
		String contactnum = excel.fetchTestData(IConstantPath.EXCEL_PATH, SheetName.AdminDetails.toString(),2, 5);
		String value = excel.fetchTestData(IConstantPath.EXCEL_PATH, SheetName.AdminDetails.toString(),2, 6);
		String email = excel.fetchTestData(IConstantPath.EXCEL_PATH, SheetName.AdminDetails.toString(),2, 7);
		String passwrd = excel.fetchTestData(IConstantPath.EXCEL_PATH, SheetName.AdminDetails.toString(),2, 8);
				
		addAdminPage.companyIdtxtBox(companyid);
		addAdminPage.firstNametxtBox(firstname);
		addAdminPage.lastNametxtBox(lastname);
		addAdminPage.middleNametxtBox(middlename);
		addAdminPage.contactNoBox(contactnum);
		webdriver.handleDropdown(addAdminPage.positionDrop(), value);
		addAdminPage.emailTxtBox(email);
		addAdminPage.passwordTxtBox(passwrd);
		addAdminPage.saveBtn();
		
		webdriver.acceptAlert();
}
}

