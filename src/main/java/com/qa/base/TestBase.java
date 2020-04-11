package com.qa.base;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {

	public static WebDriver driver;
	public static String baseURL=null;  
	
	public static void setUp(String url) {
		
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Miss Jaydevappa\\SeleniumStandaloneJarFiles\\chromedriver_win32\\chromedriver.exe");
			baseURL=url;
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(baseURL);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			System.out.println(driver.getTitle());
		}
		
	
	public static void tearDown() {
		driver.quit();
	}
	
}
