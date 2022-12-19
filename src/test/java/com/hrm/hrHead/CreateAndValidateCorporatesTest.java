package com.hrm.hrHead;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genericUtility.BaseClass;
import com.hrm.genericUtility.IConstantPath;
import com.hrm.genericUtility.PropertyFileKeys;
import com.hrm.genericUtility.SheetName;


@Listeners(com.hrm.genericUtility.ListnersImplimentation.class)
public class CreateAndValidateCorporatesTest extends BaseClass {

	@Test
	public void addCorporates() throws EncryptedDocumentException, IOException, InterruptedException {

		String randomNumberLimit = prop.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
				PropertyFileKeys.RANDOM_NUMBER_LIMIT.convertToString());
		int randomNumber = javaUtil.getRandomNumber((Integer) javaUtil.StringToAnyDatatype(randomNumberLimit, "int"));

		// read data from excel file
		String data = excel.getExcelData(IConstantPath.EXCEL_PATH, SheetName.corporate.toString(), 2, 1);

		webdriver.acceptAlert();
		compg.clickCorporate();
		compg.clickAddCorporate();
		corpPg.clickAddCorporate();

		String corpName = data + randomNumber;
		addCorporatePage.addCorporatebutton(corpName);
		addCorporatePage.saveButton();
		System.out.println(corpName);
		System.out.println("Corporate name added successfully");
		webdriver.acceptAlert();
		Thread.sleep(3000);

		compg.clickempbutton();
		compg.clickaddempbutton();
		compg.addEmployee();
		List<WebElement> listOfDept = webdriver.handleDropdown(empdetail.dropDept());

		for (WebElement actualadress : listOfDept) {
			String actualName = actualadress.getText();
			System.out.println("Actualcorp name is===>"+ actualName);
			if (actualName.equals(corpName)) {
				Reporter.log("test case is pass", true);
				empdetail.closeDetail();
			}
		}

	}

}
