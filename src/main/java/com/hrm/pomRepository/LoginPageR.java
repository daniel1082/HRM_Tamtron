package com.hrm.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPageR{

	@FindBy(name="hr_email")     private WebElement userNameTextField;
	@FindBy(name="hr_password")  private WebElement passwordTextField;
	@FindBy(id="hr_type")        private WebElement dropdown;
	@FindBy(name="login_hr")     private WebElement login;


	public LoginPageR(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used for the login Action of the application
	 * @param username
	 * @param password
	 * @param index
	 */
	public void loginAction(String username, String password) {
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
	}
	public WebElement selectDropdown()
	{
		return dropdown;
	}
	public WebElement submitclick()
	{
		return login;
	}
}
