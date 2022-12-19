package com.hrm.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HrAssistantPage {
	@FindBy(xpath="//input[@type='search']")
	private WebElement sear;	
	@FindBy(xpath="//th[@aria-label='Department: activate to sort column ascending']/ancestor::thead/following-sibling::tbody/descendant::td[text()='Credit Department']")
	private WebElement deptname;
	
	public HrAssistantPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void passempname(String empName) {
		sear.sendKeys(empName);
	}
	public String deptname() {
		System.out.println(deptname.getText());
		return deptname.getText();
	}
}
