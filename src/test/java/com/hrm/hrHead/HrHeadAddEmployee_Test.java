package com.hrm.hrHead;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genericUtility.BaseClass;
import com.hrm.genericUtility.IConstantPath;
import com.hrm.genericUtility.SheetName;

/**
 * This class is used to create new employee details
 * @author daniel
 *
 */
@Listeners(com.hrm.genericUtility.ListnersImplimentation.class)
public class HrHeadAddEmployee_Test extends BaseClass {
	@Test
	public void HrHeadEmployeeTest() throws EncryptedDocumentException, IOException {
		
		
		// creating object for generic
		String emp = excel.getExcelData(IConstantPath.EXCEL_PATH, SheetName.HRHeadEmployee.toString(), 2, 1);

//		webdriver.acceptAlert();
		compg.clickempbutton();
		compg.clickaddempbutton();
		hrheademp.searchEmployee(emp);
		hrheademp.validate(emp);
		excel.sinsertDataToExcel(2, 3, IConstantPath.EXCEL_PATH.toString(), SheetName.HRHeadEmployee.toString(),
				"pass");
	}
	
}
