package com.hrm.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EmployeeDetailPage{

	@FindBy(xpath = "//input[@name='employee_companyid']")
	private WebElement compID;
	@FindBy(xpath = "//input[@name='employee_firstname']")
	private WebElement firstname;
	@FindBy(xpath = "//input[@name='employee_lastname']")
	private WebElement lastname;
	@FindBy(xpath = "//input[@name='employee_middlename']")
	private WebElement middlename;
	@FindBy(xpath = "//input[@name='branches_datefrom']")
	private WebElement branchesDt;
	@FindBy(xpath = "//div[@class='modal-body']/div[3]/div[2]/div/input[@name='branches_recentdate']")
	private WebElement recentBrancheDt;
	@FindBy(xpath = "//div[@class='modal-body']/div[4]/div/select[@name='employee_department']")
	private WebElement empDept;
	@FindBy(xpath = "//div[@class='modal-body']/div[4]/div[2]/div/select[@name='employee_branches']")
	private WebElement empBranch;
	@FindBy(xpath = "//input[@name='employee_position' and @class='form-control']")
	private WebElement empPos;
	@FindBy(xpath = "//input[@name='employee_contact']")private WebElement empContact;
	@FindBy(xpath = "//input[@name='employee_sss']")private WebElement empSSSNo;
	@FindBy(xpath = "//input[@name='employee_tin']")private WebElement empTin;
	@FindBy(xpath = "//input[@name='employee_hdmf_pagibig']")private WebElement empBig;
	@FindBy(xpath = "//input[@name='employee_gsis']")private WebElement empGSIS;
	@FindBy(xpath = "//input[@name='employee_file201']")private WebElement fileLoad;
	@FindBy(xpath = "//input[@name='employee_image']")private WebElement imgLoad;
	@FindBy(xpath = "//button[@name='emplo']")
	private WebElement empSave;

	public EmployeeDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to create the employee in the employee detail page
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * @param branchesDate
	 * @param recentBrancheDate
	 * @param departIndex
	 * @param branchIndex
	 * @param empPosition
	 * @param empployeeContact
	 * @param employeeSSSNo
	 * @param employeeTin
	 * @param employeeBig
	 * @param employeeGSIS
	 * @param filePath
	 * @param imgPath
	 * @throws InterruptedException
	 */
	public void creatEmployee(String id, String firstName, String lastName, String middleName, String branchesDate,
			String recentBrancheDate) throws InterruptedException {
		compID.sendKeys(id);
		firstname.sendKeys(firstName);
		lastname.sendKeys(lastName);
		middlename.sendKeys(middleName);
		branchesDt.sendKeys(branchesDate);
		recentBrancheDt.sendKeys(recentBrancheDate);

	}
	public WebElement deptEle()
	{
		return empDept;
	}

	public WebElement branchEle()
	{
		return empBranch;
	}
	public void sendDetails( String empPosition,
			String empployeeContact, String employeeSSSNo, String employeeTin, String employeeBig, String employeeGSIS)
	{
		empPos.sendKeys(empPosition);
		empContact.sendKeys(empployeeContact);
		empSSSNo.sendKeys(employeeSSSNo);
		empTin.sendKeys(employeeTin);
		empBig.sendKeys(employeeBig);
		empGSIS.sendKeys(employeeGSIS);
	}
	public WebElement fileLoading()
	{
		return fileLoad;
	}

	public WebElement imgLoading()
	{
		return imgLoad;
	}

	public void submit()
	{
		empSave.click();
	}

}


