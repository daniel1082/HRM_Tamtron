package com.hrm.hrHead;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.hrm.genericUtility.BaseClass;
import com.hrm.genericUtility.IConstantPath;
import com.hrm.genericUtility.PropertyFileKeys;
import com.hrm.genericUtility.SheetName;


public class AddCorporates_Test extends BaseClass {

@Test
	public void addCorporates() throws EncryptedDocumentException, IOException {
		

		String randomNumberLimit=prop.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.RANDOM_NUMBER_LIMIT.convertToString()); 
		int randomNumber=javaUtil.getRandomNumber((Integer)javaUtil.StringToAnyDatatype(randomNumberLimit, "int"));

		//read data from excel file
		String data = excel.getExcelData(IConstantPath.EXCEL_PATH,SheetName.corporate.toString(),2,1);		

	webdriver.acceptAlert();


		compg.clickCorporate();
		compg.clickAddCorporate();
		corpPg.clickAddCorporate();


		addCorporatePage.addCorporatebutton(data+randomNumber);
		addCorporatePage.saveButton();
		System.out.println(data+randomNumber);
		System.out.println("Corporate name added successfully");


		webdriver.acceptAlert();
	}	

}
