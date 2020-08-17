package com.simform.base;

import org.openqa.selenium.By;

import com.simform.crm.accounts.AccountsPage;

public class TopMenu {

	public void gotoHome() {

	}

	public void gotoFeeds() {

	}

	public void gotoLeads() {

	}

	public AccountsPage gotoAccounts() {
		
		Page.driver.findElement(By.linkText("Accounts")).click();
		
		return new AccountsPage();

	}

	public void gotoContacts() {

	}
	
	public void signOut() {
		
		
	}

}
