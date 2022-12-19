package com.hrm.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CorporatePage {

	@FindBy(xpath="//h3[@class='card-title']/button[@class='btn btn-primary']")
	private WebElement AddCorporate;
	

	public CorporatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to click add corporate button
	 */
	public void clickAddCorporate() {
		AddCorporate.click();
	}

}
