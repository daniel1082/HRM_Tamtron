package com.hrm.pomRepository;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class HrHeadEmployeePage {

	@FindBy(xpath="//input[@type='search']")
	private WebElement search;

	@FindBy(xpath="//table/tbody/tr/td[3]")
	private List<WebElement> name;

	public HrHeadEmployeePage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	/**
	 * This method is used to search the name of the employee in the employee page
	 * @param emp
	 */
	public void searchEmployee(String emp)
	{
		search.sendKeys(emp);
	}

	/**
	 * This method is used to validate the employee name
	 * @param expectedname
	 */
	public void validate(String expectedname)
	{
		for(WebElement actualName:name)
		{
			String actualname = actualName.getText();
			if (actualname.equals(expectedname)) {
				System.out.println(actualname+" is searched ");
				System.out.println("Expected name is present");
			}
			else {
				System.out.println(actualname+"is not present in employee list");
			}
		}
	}

}
