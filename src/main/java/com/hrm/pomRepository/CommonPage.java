package com.hrm.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genericUtility.BaseClass;


public class CommonPage extends BaseClass {
	WebDriver driver;

	@FindBy(xpath="//p[contains(text(),'BRANCHES')]")    private WebElement Branches;
	@FindBy(xpath="//p[contains(text(),'Add Braches')]") private WebElement AddBranches;


	//bhagya
	@FindBy(xpath ="//a[@class='nav-link']/i[@class='nav-icon fa fa-handshake']")
	private WebElement CorporateTab;
	@FindBy(xpath="//p[text()='Add Corporate']")
	private WebElement AddCorporateTab;

	//sebin
	@FindBy(xpath="//a[@class='nav-link']/i[@class='nav-icon fas fa-user']")
	private WebElement empbutton;

	@FindBy(xpath="//p[text()='Add Employee']")
	private WebElement addempbutton;


	


	@FindBy (xpath="//i[@class='fa fa-user']") 
	private WebElement profile;
	@FindBy (xpath="//i[@class='fa fa-user-cog']")
	private WebElement accSet;
	@FindBy (xpath="//i[@class='fa fa-power-off']")
	private WebElement logout;
	@FindBy (xpath="//img[@class='brand-image img-circle elevation-3']")
	private WebElement mouseHover;
	@FindBy (xpath="//i[@class='fas fa-angle-left right']")
	private WebElement addEmpDropDown;
	@FindBy (xpath="//p[text()='Add Employee']") 
	private WebElement addEmpRadio;
	@FindBy (xpath="//h1[text() ='Dashboard']/ancestor::div[@class='content-header']/following-sibling::section[@class='content']/descendant::button[@class='btn btn-primary'][1]")
	private WebElement addEmpButton;



	@FindBy(xpath="//i[@class='fa fa-user']")         private WebElement icon;
	@FindBy(xpath="//i[@class='fa fa-power-off']")    private WebElement logoutlink;

	public CommonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to click the branches
	 */
	public void clickBranches() {
		Branches.click();
	}

	/**
	 * This method is used to click add branches in commonpage
	 */
	public void clickAddBranches() {
		AddBranches.click();
	}

	/**
	 * This method is used to click the corporate in common page
	 */
	public void clickCorporate() {
		CorporateTab.click();	
	}
	
	/**
	 * This method is used to click add corporate in the common page
	 */
	public void clickAddCorporate() {
		AddCorporateTab.click();
	}

	/**
	 * This method is used to click the employee button in common page
	 */
	public void clickempbutton(){
		empbutton.click();
	}

	/**
	 * This method is used to click add employee button in the common page
	 */
	public void clickaddempbutton(){
		addempbutton.click();
	}

	
	
	/**
	 * This method is used add employee in the common page
	 */
	public void addEmployee(){
		addEmpButton.click();	
	}

	/**
	 * This method is used to click for the employee details
	 */
	public void clickForEmpDetails(){
		addEmpDropDown.click();
		addEmpRadio.click();
	}

	
	
	/**
	 * This method is used to perform the logout action
	 */
	public void logoutAction() {
		icon.click();
		logoutlink.click();
	}

	public WebElement profilebutton()
	{
		return profile;
	}
	public WebElement logoutButton()
	{
		return logout;
	}
}
