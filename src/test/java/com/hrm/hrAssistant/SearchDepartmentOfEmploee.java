package com.hrm.hrAssistant;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genericUtility.BaseClass;
import com.hrm.genericUtility.IConstantPath;
import com.hrm.genericUtility.SheetName;
@Listeners(com.hrm.genericUtility.ListnersImplimentation.class)
public class SearchDepartmentOfEmploee extends BaseClass{
	@Test
	public void searchDepartEmp() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String empName1 = excel.getExcelData(IConstantPath.EXCEL_PATH, SheetName.HRHeadEmployee.toString(), 2, 1);
		webdriver.acceptAlert();
		compg.clickempbutton();
		compg.clickaddempbutton();
		hrassis.passempname(empName1);
		hrassis.deptname();
		
		Thread.sleep(2000);
		
	}

}
