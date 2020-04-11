package com.qa.util;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Utilities  {
	
	public WebDriver driver;
	public WebElement element;
	private String keysToSend;

	public WebElement doReturnWebElement(WebDriver driver, By locator) {
		this.driver = driver;
		element = driver.findElement(locator);
		return (element);
	}

	public void doSendKeys(WebDriver driver, By locator, String keysToSend) {
		this.driver = driver;
		this.keysToSend = keysToSend;
		element = doReturnWebElement(driver, locator);
		doClear(driver,locator);
		element.sendKeys(keysToSend);

	}

	public void doClick(WebDriver driver, By locator) {
		this.driver = driver;

		element = doReturnWebElement(driver, locator);
		element.click();

	}
	public void doClear(WebDriver driver, By locator) {
		this.driver = driver;

		element = doReturnWebElement(driver, locator);
		element.clear();

	}
	
	public void doClickCheckBox(WebDriver driver, By locator) {
		this.driver = driver;

		element = doReturnWebElement(driver, locator);
		if(!element.isSelected()) {
			System.out.println("Checkbox was not selected");
			element.click();
			System.out.println("selecting the check box now ");
		}
		else
			System.out.println("Checkbox is  selected");
		
	}
	
	
	public String doGetText(WebDriver driver, By locator) {
		this.driver = driver;

		element = doReturnWebElement(driver, locator);
		String str =element.getText();
		return str;

	}
	
	public  WebElement waitForElementWithFluentWait(WebDriver driver, By locator,int timeOut,int pollTime)
	{
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
						   .withTimeout(Duration.ofSeconds(timeOut))
						  .pollingEvery(Duration.ofSeconds(pollTime))
						  .ignoring(NoSuchElementException.class);
						  
	return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	
}
