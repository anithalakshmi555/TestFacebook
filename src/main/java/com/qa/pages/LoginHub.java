package com.qa.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;
import com.qa.config.*;
import com.qa.util.Utilities;

public class LoginHub extends TestBase {
		FileReader file;
		String line;
		WebDriverWait mywait;
		public String emailAddress,password,drpdownValue,urlReview,reviewrating,urlWalletHub;
		int s, a,b;
		FileInputStream fis;
		
		By review = By.xpath("//button[@class='btn blue-brds']");
		By header = By.xpath("//h4[@class='wrev-prd-name']");
		By txtArea = By.xpath("//div[@class='wrev-user-input-box input-field progress-indicator-container']/div/textarea");
		By subBtn = By.xpath("//div[@class='sbn-action semi-bold-font btn fixed-w-c tall']");
		
		public LoginHub()
		{
		
			Properties prop = new Properties();
			
				try {
					fis = new FileInputStream("C:\\Users\\Miss Jaydevappa\\eclipse-workspace\\Assignment\\src\\main\\java\\config\\config.properties");
					prop.load(fis);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				 emailAddress=prop.getProperty("emailaddress");
				 password=prop.getProperty("password");
				 drpdownValue=prop.getProperty("drpdownValue");
				 urlWalletHub=prop.getProperty("urlWalletHub");
				 urlReview=prop.getProperty("urlReview");
				 reviewrating=prop.getProperty("reviewrating");
		}

		/*
		 * Launching Facebook
		 */
			
		public  void launchWalletHub() {
			setUp(urlWalletHub);
		}
		
		
		/*
		 * Close the browser
		 */
		public  void closeWalletHub() {
			tearDown();
		}
		
		/*
		 * Launching walletHub for review
		 */
		
		
		public void writeReview() {
			driver.findElement(review).click();
			String hdr=driver.findElement(header).getText();
			System.out.println("Header is "+ hdr);
		}
		
		
		/*
		 * To hover on the review stars
		 * 
		 */
		
		// Total number of stars lit up before hovering 
		
		public void hoverOnStars() {
			By litOff = By.xpath("//*[@fill='none' ]");
			List<WebElement> l1 = driver.findElements(By.xpath("//*[@fill='none']"));
			a=l1.size();
			s=a-48;
			System.out.println("Total number of stars lit up before hovering  " + s);
					
			WebElement star = driver.findElement(By.xpath("//error-toast[@class='wrev-error']//following-sibling::review-star//child::div"));
			By star1 = By.xpath("//error-toast[@class='wrev-error']//following-sibling::review-star");
			Actions action = new Actions(driver);
			action.moveToElement(star).build().perform();
			mywait= new WebDriverWait(driver,30);
			mywait.until(ExpectedConditions.visibilityOfElementLocated(star1));
			action.moveToElement(star).build().perform();
		
			// Total number of stars lit up  after hovering 
			List<WebElement> l2 = driver.findElements(By.xpath("//*[@fill='none']"));
			b=l2.size();
			s=b-a;
			System.out.println("Total number of stars lit up after hovering  " + s);
			
		}
	
	
		/*
		 * Clicking on the 4th star
		 */
		public void clickOnStar() {
			List<WebElement> starsCount = driver.findElements(By.xpath("//*[@class='rvs-star-svg' and @width='38' and @height='35.75']"));
			System.out.println("The of the stars availble for  the review is " + starsCount.size());
			for (int i = 0; i < starsCount.size(); i++) {
				starsCount.get(i).click();
				if (i == 3)
				{	
					System.out.println("Total number of stars clicked is   " + (i+1));
					break;
				}	
			}
		}
	
		/*
		 * To select the Health Insurance from the dropdown list
		 */
		public void selectDropDown() {
			WebElement dropDown = driver.findElement(By.xpath("//div[@class='dropdown second']"));
			dropDown.click();
			By dropDownSelected = By.xpath("//div[@class='dropdown second opened']");
			mywait= new WebDriverWait(driver,20);
			mywait.until(ExpectedConditions.presenceOfElementLocated(dropDownSelected));
			List<WebElement> dropdownlist = driver.findElements(By.xpath("//ng-dropdown[@class='wrev-drp']/div/ul/li"));
			System.out.println("The number of Items in the dropdown is " + dropdownlist.size());
			for (int i = 0; i < dropdownlist.size(); i++) {
	
				if (drpdownValue.equals(dropdownlist.get(i).getText())) {
					dropdownlist.get(i).click();
				}
	
			}
		}
		
		
		/*
		 * To enter 200 words in the text area
		 * 
		 */
		
		public void enterText() throws IOException {
		try {
			file = new FileReader("C:\\Users\\Miss Jaydevappa\\eclipse-workspace\\Assignment\\data.txt");
			BufferedReader br = new BufferedReader(file);
			while ((line = br.readLine()) != null) {
			//	WebElement textArea = wltHb.doReturnWebElement(driver, txtArea);
				driver.findElement(txtArea).sendKeys(line);
			//	textArea.sendKeys(line);
			}
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
			}
		
		
		/*
		 * to click on submit button 
		 */
		mywait = new WebDriverWait(driver, 5);
		mywait.until(ExpectedConditions.elementToBeClickable(subBtn));
		driver.findElement(subBtn).click();
	}
		
		

		/*
		 * To check the review written 
		 */
		public void lauchReview() {
		setUp(urlReview);}
		
		public void checkReview() {
			By revlink = By.xpath("//a[contains(text(),'Test Insurance Company')]");
			By reviewer = By.xpath("//span[@class='rvtab-ci-name']//following-sibling::span[contains(text(),'@anithalakshmi860')]");
			By revStar = By.xpath("//span[@class='rvtab-ci-name']//following-sibling::span[contains(text(),'@anithalakshmi860')]//ancestor::div[2]//following-sibling::review-star");
			driver.findElement(revlink).click();
			//WebElement revLink=wltHb.waitForElementWithFluentWait(driver,revlink,30,5);
			//wltHb.doClick(driver,revlink);
		
			
			/*
			 * checking the reviewer name
			 */
			String rev=driver.findElement(reviewer).getText();
			if (rev.contains("@anithalakshmi860")) {
				System.out.println("Review of Anitha found");
			}
	
		
			
			/* 
			 * This is for getting the number of stars of the review
			 */
			WebElement revStarCmp=driver.findElement(revStar);
			String revs = revStarCmp.getAttribute("ng-reflect-rating");
			if (revs.equals(reviewrating)) {
				System.out.println(reviewrating +"  stars found and review is asserted");}
			else
			   {System.out.println("star rating did not match");}	
			
			}
	}

	

