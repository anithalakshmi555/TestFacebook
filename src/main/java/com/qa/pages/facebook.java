package com.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;
import com.qa.config.*;
import com.qa.util.Utilities;

public class facebook extends TestBase {
		public String username;
		public String password;
		public String usr,ps,pst,facebookurl,fbUsrName,fbTitle;
		WebDriverWait mywait;
		
		/*
		 * Finding the web elements through By locator
		 */
		By userName= By.xpath("//input[@id='email']");
		By pass= By.xpath("//input[@id='pass']");
		By lgnBtn= By.xpath("//input[@id='u_0_b']");
		By txtPost=By.xpath("//textarea[@name='xhpc_message']");
		By lnkCrtPst=By.xpath("//a[@class='_4-h7 _5qtn']");
		By lnkPost=By.xpath("//button[@class='_1mf7 _4r1q _4jy0 _4jy3 _4jy1 _51sy selected _42ft']/span");
	
	
		/*
		 *Reading the properties file  
		 */
		
	
	  public facebook() { 
		  
		  try {
			  
			  Properties prop = new Properties(); 
			  FileInputStream fis = new  FileInputStream("C:\\Users\\Miss Jaydevappa\\eclipse-workspace\\Assignment\\src\\main\\java\\config\\config.properties");
			  prop.load(fis);
			  usr=prop.getProperty("usr"); 
			  ps=prop.getProperty("ps");
			  pst=prop.getProperty("pst"); 
			  facebookurl=prop.getProperty("facebookurl");
			  fbUsrName=prop.getProperty("fbUsrName");
			  fbTitle=prop.getProperty("fbTitle");
		  }
		  catch (Exception e) {
				
				e.printStackTrace();
			} 
	  }
	 
	
	
//	  public void readPropertiesFile() throws Exception 
//	  { 
//		  Properties prop = new  Properties();
//		  FileInputStream fis = new	  FileInputStream("C:\\Users\\Miss Jaydevappa\\eclipse-workspace\\Assignment\\src\\main\\java\\config\\config.properties"
//		  );
//		  prop.load(fis);
//		  usr=prop.getProperty("usr"); ps=prop.getProperty("ps");
//		  pst=prop.getProperty("pst"); facebookurl=prop.getProperty("facebookurl");
//		  fbUsrName=prop.getProperty("fbUsrName"); fbTitle=prop.getProperty("fbTitle");
//	  }
//	 
		

		
		/*
		 * Launching Facebook
		 */
			
		public  void launchFacebook() {
			setUp(facebookurl);
		}
		
		
		/*
		 * Close the browser
		 */
		public  void closeFacebook() {
			tearDown();
		}
		

			
		/*
		 * Login to facebook
		 */

		public  void loginFacebook() {
			driver.findElement(userName).sendKeys(usr);
			driver.findElement(pass).sendKeys(ps);
			driver.findElement(lgnBtn).click();
			}
		
		
		/*
		 * Displaying title of the facebook
		 */
		public String getFaceBookTitle() {
			
			mywait=new WebDriverWait(driver,200);
			mywait.until(ExpectedConditions.titleIs(fbTitle));
			String title=driver.getTitle();
			return title;
		}
		

		
		/*
		 * sending the post hello world 
		 */
			
			public  void postMessage()
			{
				Actions action = new Actions(driver);
				action.sendKeys(Keys.ESCAPE).build().perform(); 
				action.sendKeys(Keys.ESCAPE).build().perform(); 
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
						 .withTimeout(Duration.ofSeconds(100))
						 .pollingEvery(Duration.ofSeconds(15))
						 .ignoring(NoSuchElementException.class);
				WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(lnkCrtPst));
				driver.findElement(lnkCrtPst).click();
				mywait = new WebDriverWait(driver, 10);
				mywait.until(ExpectedConditions.presenceOfElementLocated(txtPost));
				driver.findElement(txtPost).sendKeys(pst);
				driver.findElement(lnkPost).click();
				System.out.println("Successfully posted the message " +pst);
			}
		
	}

	



