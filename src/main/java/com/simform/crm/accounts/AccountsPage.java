package com.simform.crm.accounts;

import org.openqa.selenium.By;

import com.simform.base.Page;

public class AccountsPage extends Page {
	
	
	public CreateAccounts gotoCreateAccounts() {
		
		
		click("accountlink");
		
		return new CreateAccounts();
	}
	
	public void gotoImportAccounts() {
		
		
	}

}
