package com.hrm.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BranchesPage {
	
	
	@FindBy(xpath="//button[@class='btn btn-primary']")  private WebElement AddBranches;
	

	public BranchesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	 
	/**
	 * This method is used to click the add branches button
	 */
	public void  clickAddBranches() {
		AddBranches.click();
		
	}

}
