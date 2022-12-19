package com.hrm.hrHead;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.hrm.genericUtility.BaseClass;
import com.hrm.genericUtility.IConstantPath;
import com.hrm.genericUtility.PropertyFileKeys;
import com.hrm.genericUtility.SheetName;
@Listeners(com.hrm.genericUtility.ListnersImplimentation.class)
public class AddBranches_Test extends BaseClass {

	@Test
	public void addBranchesTest() throws EncryptedDocumentException, IOException {

		// Generating random Number
		String randomNumberLimit = prop.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
				PropertyFileKeys.RANDOM_NUMBER_LIMIT.convertToString());
		int randomNumber = javaUtil.getRandomNumber((Integer) javaUtil.StringToAnyDatatype(randomNumberLimit, "int"));

		String data = excel.getExcelData(IConstantPath.EXCEL_PATH, SheetName.Branches.toString(), 2, 1);

		webdriver.acceptAlert();

		compg.clickBranches();
		compg.clickAddBranches();
		branchesPage.clickAddBranches();

		addBranchesPage.addBranchesText(data + randomNumber);
		addBranchesPage.saveButton();

		System.out.println(data + randomNumber);
		System.out.println("Branches created succesfully");

		webdriver.acceptAlert();

	}

}
