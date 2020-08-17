package com.simform.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.simform.base.Page;

public class LoginPage extends Page {
	
	
	public ZohoAppPage doLogin(String username, String password) throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login_id']")));
		type("emailfield",username);
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='nextbtn']")));
		click("emailnext");
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		type("passwordfield",password);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn blue' and span='Sign in']")));
		click("passwordnext");
		
		return new ZohoAppPage();
	}

}
