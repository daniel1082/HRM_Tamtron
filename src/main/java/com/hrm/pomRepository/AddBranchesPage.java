package com.hrm.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBranchesPage {
	@FindBy(xpath="//div/form/div/input[@name='branches_name']") private WebElement AddBranchesText;
	@FindBy(name="bran")                                         private WebElement save;
	
	
	
	
	public AddBranchesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is to add the branch name in the field
	 * @param data
	 */
	public void addBranchesText(String data) {
		AddBranchesText.sendKeys(data);
		
	}

	/**
	 * This method is used to save the branch name entered
	 */
	public void saveButton() {
		save.click();
		
	}

}
