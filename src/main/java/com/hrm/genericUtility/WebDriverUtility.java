package com.hrm.genericUtility;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * This class contains common webdriver actions
 * @author daniel
 *
 */
public class WebDriverUtility {
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	
	/**
	 * This method is used to launch the application by taking browser and url
	 * @param browser
	 * @param timeout
	 * @param url
	 * @return
	 */
	public WebDriver launchAppliction(String browser, long timeout, String url) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("Microsoft edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(url);
		return driver;

	}

	/**
	 * This method is used to accept the alert popup
	 */
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	/**
	 *This method is used to dismiss the alert popup
	 */
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 *This method is used to fetch the text present in the alert popup
	 */
	public void getTextOfAlert() {
		driver.switchTo().alert().getText();
	}

	/**
	 * This method is used to handle the dropdown by using select class and in the by getoptions method
	 * @param ele
	 * @return
	 */
	public List<WebElement> handleDropdown(WebElement ele){
		Select sel=new Select(ele);
		List<WebElement> value=sel.getOptions();
		return value;
	}

	/**
	 * This method is used to handle the dropdown by using select class and in the by 
		    selectByvisibleText method
	 * @param ele
	 * @return
	 */
	public void handleDropdown(WebElement ele,String text){
		Select sel=new Select(ele);
		sel.selectByVisibleText(text);
	}

	/**
	 * This method is used to handle the dropdown by using select class and in the by 
		   selectByIndex method
	 * @param ele
	 * @return
	 */
	public void handleDropdown(WebElement ele,int index){
		Select sel=new Select(ele);
		sel.selectByIndex(index);
	}

	/**
	 * This method is used to handle the dropdown by using select class and in the by 
		   selectByValue method
	 * @param name
	 * @param ele
	 */
	public void handleDropdown(String name,WebElement ele){
		Select sel=new Select(ele);
		sel.selectByValue(name);
	}


	/**
	 * This method is used to mouseHover an element by using action class in moveByOffset method
	 * @param x
	 * @param y
	 */
	public void mouseHoverOn(int x,int y) {
		Actions a=new Actions(driver);
		a.moveByOffset(x, y).perform();
	}

	/**
	 * This method will perform mouse hover action on a particular element
	 * @param driver
	 * @param target
	 */
	public void mouseHoverOn(WebElement target)
	{
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
	}

	/**
	 * This method is used to rightClick an element by using action class in contextClick method
	 */
	public void rightClickOn() {
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}

	/**
	 * This method is used to rightClick an element by using action class in contextClick method by 
				   passing element as parameter
	 * @param element
	 */
	public void rightClickOn(WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This method is used to doubleClick an element by using actions class in doubleClick method.
	 */
	public void doubleClickOn() {
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}

	
	/**
	 * this method will wait for specified time in seconds for the entire DOM structure to load
	 * @param driver
	 */
	public void waitForElementsToLoadInDOM(long time) {
		
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}
	
	
	
	
	/**
	 * This method will wait for particular element to be visible
	 * @param driver
	 * @param element
	 */
public void waitForElementToLoad(WebElement element) {

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used for explicit wait unt the element to invisible
	 * @param element
	 */

	public void waitForElementtoInvissible(WebElement element,long time) {

		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**'
	 * This method will wait for particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebElement element, long time) {

		wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}


	
	/**
	 * This method will wait for the particular element to perform click operation
	 * if the element is not interactive it will wait for 1 second 
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWaitAndClickOnElement(WebElement element) throws InterruptedException {
		
		int count = 0;
		while(count<10) {
			try 
			{
				element.click();
				break;
			}
			catch(Exception e) 
			{
				Thread.sleep(200);
				count++;
			}
		}
		
	}
	
	

	
	/**
	 * This method is used to file class and convert absolute path
	 * @param path
	 * @return
	 */
	public String externalFiles(String path)
	{
		File doc = new File(path);
		String file = doc.getAbsolutePath();
		return file;
	}

	/**
	 * This method is used for javascript executor
	 * @param element
	 */
	public void executerClick(WebElement element)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click();", element);
	}

	/**
	 * This method is used for javascript executor and send the values
	 * @param element
	 * @param text
	 */
	public void executerSendKeys(WebElement element, String text)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].value='"+text+"';", element);
	}


	/**
	 * This method is used to switch the window
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchingTheWindows(String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String wId = it.next();
			driver.switchTo().window(wId);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	
	
	/**
	 * This method is used to take screen shot with unique id
	 * @param testCaseName
	 * @return
	 * @throws IOException
	 */
	public String getErrorshots(String testCaseName) throws IOException {
		String fileName = testCaseName+ "_"+ new JavaUtility().getDateTime();
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst= new File("./screenshot/"+fileName+".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();
	}

	
	/**
	 * This method is used to take screen shot base64 with unique id
	 * @param testCaseName
	 * @return
	 * @throws IOException
	 */
	public String getErrorshotsBase64(){
		TakesScreenshot ts =(TakesScreenshot)driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		return src;
		
	}

}

