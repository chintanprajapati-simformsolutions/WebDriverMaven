package com.simform.crm.accounts;

import org.openqa.selenium.By;

import com.simform.base.Page;

public class CreateAccounts extends Page {
	
	public void createAccount (String accountName) {
		
		//driver.findElement(By.xpath("//input[@data-zcqa='Account Name']")).sendKeys(accountName);
		type("accountname",accountName);
	}

}
