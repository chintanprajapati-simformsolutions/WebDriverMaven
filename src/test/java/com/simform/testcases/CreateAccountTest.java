package com.simform.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.simform.base.Page;
import com.simform.crm.accounts.AccountsPage;
import com.simform.crm.accounts.CreateAccounts;
import com.simform.pages.ZohoAppPage;
import com.simform.utilities.Utilities;

public class CreateAccountTest {
	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String,String> data) {
		
		ZohoAppPage zp = new ZohoAppPage();
		zp.gotoCRM();

		AccountsPage account = Page.menu.gotoAccounts();

		CreateAccounts cap = account.gotoCreateAccounts();
		cap.createAccount(data.get("accountname"));
		
	}

}
