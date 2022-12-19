package com.hrm.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAdminPage {
	
	
	@FindBy (xpath="//div[@class='form-group']/input[@name='hr_companyid']")
	private WebElement companyIdtxt;
	@FindBy (xpath="//div[@class='form-group']/input[@name='hr_firstname']")
	private WebElement firstnametxt;
	@FindBy (xpath="//div[@class='form-group']/input[@name='hr_lastname']")
	private WebElement lastnametxt;
	@FindBy (xpath="//div[@class='form-group']/input[@name='hr_middlename']")
	private WebElement middlenametxt;
	@FindBy (xpath="//div[@class='form-group']/input[@name='hr_contactno']")
	private WebElement contacttxt;
	@FindBy (xpath="//div[@class='form-group']/select[@id='hr_type']")
	private WebElement positionbox;
	@FindBy (xpath="//div[@class='form-group']/input[@name='hr_email']")
	private WebElement emailtxt;
	@FindBy (xpath="//div[@class='form-group']/input[@name='hr_password']")
	private WebElement pwdtxt;
	@FindBy (xpath="//div/button[text()='Save']")
	private WebElement savebtn;
	
	
	
	
	public AddAdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void companyIdtxtBox(String companyid) {
		companyIdtxt.sendKeys(companyid);
	}
	
	public void firstNametxtBox(String name) {
		firstnametxt.sendKeys(name);
	}
	
	public void lastNametxtBox(String name) {
		lastnametxt.sendKeys(name);
	}
	
	public void middleNametxtBox(String name) {
		middlenametxt.sendKeys(name);
	}
	
	public void contactNoBox(String number) {
		contacttxt.sendKeys(number);
	}
	
	public WebElement positionDrop() {
		 return positionbox;
	}
	 
	public void emailTxtBox(String email) {
		emailtxt.sendKeys(email);
	}
	
	
	public void passwordTxtBox(String pwd) {
		pwdtxt.sendKeys(pwd);
	}
	
	public void saveBtn() {
		savebtn.click();
	}

	
}
