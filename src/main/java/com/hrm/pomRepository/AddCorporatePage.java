package com.hrm.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCorporatePage {
	@FindBy(name="corporate_name") private WebElement AddCorporateText;

	@FindBy(xpath="//button[text()='Save']")private WebElement savebutton;

	
	
	public AddCorporatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	} 

	/**
	 * This method is used to add corporate
	 * @param data
	 */
	public void addCorporatebutton(String data) {
		AddCorporateText.sendKeys(data);
	}


	/**
	 * This method is used to save the corporate text added
	 */
	public void saveButton() {
		savebutton.click();


	}

}
