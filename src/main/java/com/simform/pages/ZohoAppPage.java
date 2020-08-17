package com.simform.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.simform.base.Page;
import com.simform.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page {
	

	public void gotoChat() {
		
		
	}
	
	public CRMHomePage gotoCRM() {
		
		click("CRMlink");
		
		return new CRMHomePage();
	}
	
	public void gotoSalesIQ() {
		
		
		
	}
}
