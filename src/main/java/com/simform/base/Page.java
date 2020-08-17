package com.simform.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.simform.utilities.ExcelReader;
import com.simform.utilities.ExtentManager;
import com.simform.utilities.Utilities;
//import com.live.utilities.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Page {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devinpouyLogger");
	public static ExcelReader excel = new ExcelReader(
			"/Users/chintan.prajapati/Desktop/PageObjectModelBasics/src/test/resources/excel/Array test.xlsx");
	public static WebDriverWait wait;
	public ExtentReports reo = ExtentManager.getInstance();
	public static ExtentTest test;
	public static TopMenu menu;
	
	//Logs
	//Properties
	//Excel
	//implicit and Explicit wait
	//Extent Reports

	public Page() {
		if (driver == null) {

			// FileInputStream fis;
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("firefox")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver");
				driver = new ChromeDriver();

			} else if (config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver");
				driver = new ChromeDriver();

			}

			driver.get(config.getProperty("testsiteURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicity.wait")), TimeUnit.SECONDS);
			wait = new WebDriverWait (driver,30);	
			
			
//			System.setProperty("webdriver.chrome.driver",
//					System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver");
//			driver = new ChromeDriver();
//			driver.get("https://www.zoho.com/");
//			// driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			menu = new TopMenu();
		}
	}
	
	public static void quit() {
		
		driver.quit();
	}
	
	//Common Keywords
public void click(String locator) {
		
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		test.log(LogStatus.INFO, "Clicking on" + locator);
				
	}
	
	public void type(String locator, String value) {
		
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		test.log(LogStatus.INFO, "Typing in" +locator+ "Entered value as" +value);
	}
	static WebElement dropdown;
	
	
	public void select(String locator, String value) {
		dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		
		Select select = new Select (dropdown);
		select.selectByVisibleText(value);
		
		
		test.log(LogStatus.INFO, "Selecting value " + locator + "Value as" + value);

		
		
	}
	
	public boolean isElementPresent (By by) {
		
		try {
			
			driver.findElement(by);
			return true;
			
		}catch(NoSuchElementException e) {
				
				return false;
				
			}
		
		
		
	}
	
	public static void verifyEquals(String expected, String actual) throws IOException {
		try {
			Assert.assertEquals(actual, expected);
			
		}catch (Throwable t) {
			
			Utilities.captureScreenshot();
			
			//ReportNG
			Reporter.log("<br>"+"Verification Failure : "+ t.getMessage()+"<br>");
			Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+">Screenshot</a>");
			
			//Extent Report
			test.log(LogStatus.FAIL, "Verification Failure: " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));

			
		}

}
	
}
