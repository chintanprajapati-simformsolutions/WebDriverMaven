package com.simform.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.simform.base.Page;

public class HomePage extends Page {
	

	
	
	public void goToSupport() {
	
		click("support");
		
	}
	
	public void goToSignUP() {
		
		click("signuplink");
		
	}

	
	
	 public LoginPage goToLogin() {
		 System.out.println("Test");
click("loginlink");

		 return new LoginPage();
	 }
	 
	 public void goToZohoEdu() {
		 
		 
		 
		 
	 }
	 
	 public void goToLearnMore() {
		 
		 
		 
	 }
	 
	 public void validateFooterLinks() {
		 
		 
		 
	 }

}
