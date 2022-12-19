package com.hrm.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.hrm.pomRepository.AddBranchesPage;
import com.hrm.pomRepository.AddCorporatePage;
import com.hrm.pomRepository.BranchesPage;
import com.hrm.pomRepository.CommonPage;
import com.hrm.pomRepository.CorporatePage;
import com.hrm.pomRepository.EmployeeDetailPage;
import com.hrm.pomRepository.HrHeadEmployeePage;
import com.hrm.pomRepository.LoginPageR;

/**
 * This class consist of all launching the browser, login and logout from the
 * application and closing the browser methods
 * 
 * @author daniel
 *
 */

public class BaseClass {
	protected WebDriver driver;
	protected WebDriverUtility webdriver;
	protected PropertyLibrary prop;
	protected ExcelLibrary excel;
	protected JavaUtility javaUtil;
	protected LoginPageR login;
	protected CommonPage compg;
	protected EmployeeDetailPage empdetail;
	protected BranchesPage branchesPage;
	protected AddBranchesPage addBranchesPage;
	protected AddCorporatePage addCorporatePage;
	protected CorporatePage corpPg;
	protected HrHeadEmployeePage hrheademp;

	@BeforeClass
	public void launchBrowser() {

		// create object for all utility
		webdriver = new WebDriverUtility();
		excel = new ExcelLibrary();
		prop = new PropertyLibrary();
		javaUtil = new JavaUtility();

		// setting up of webdriverUtility
		ThreadSafe.setWebdriverUtility(webdriver);

		// launching the application
		driver = webdriver.launchAppliction(
				prop.getPropertyData(IConstantPath.PROPERTY_FILE_PATH, PropertyFileKeys.BROWSER.convertToString()), 10,
				prop.getPropertyData(IConstantPath.PROPERTY_FILE_PATH, PropertyFileKeys.URL.convertToString()));

		// create object for repository
		compg = new CommonPage(driver);
		login = new LoginPageR(driver);
		empdetail = new EmployeeDetailPage(driver);
		branchesPage = new BranchesPage(driver);
		addBranchesPage = new AddBranchesPage(driver);
		addCorporatePage = new AddCorporatePage(driver);
		corpPg = new CorporatePage(driver);
		hrheademp = new HrHeadEmployeePage(driver);
	}

	@BeforeMethod
	public void loginActions() {

//		String username = prop.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
//				PropertyFileKeys.USERNAMEOFFICER.convertToString());
//		String password = prop.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
//				PropertyFileKeys.PASSWORDOFFICER.convertToString());

		String username = prop.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
				PropertyFileKeys.USERNAME.convertToString());
		String password = prop.getPropertyData(IConstantPath.PROPERTY_FILE_PATH,
				PropertyFileKeys.PASSWORD.convertToString());
		login.loginAction(username, password);
		WebElement ele = login.selectDropdown();
		webdriver.handleDropdown(ele, 1);
		login.submitclick().click();
	}

	@AfterMethod(alwaysRun = true)
	public void logoutActionfromApp() {
		webdriver.executerClick(compg.profilebutton());
		compg.logoutButton();

	}

	@AfterClass
	public void closeApplcation() {

		driver.quit();
		System.out.println("browser Closed sucessefully");

	}
}
