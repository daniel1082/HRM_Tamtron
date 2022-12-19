package com.hrm.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	
	@FindBy (xpath="//h3[@class='card-title']/button[contains(text(),'Add Admin')]")
	private WebElement addadminbtn;

public AdminPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void clickAddAdminBtn() {
	addadminbtn.click();
}
}