package com.simform.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.simform.base.Page;
import com.simform.crm.accounts.AccountsPage;
import com.simform.crm.accounts.CreateAccounts;
import com.simform.pages.HomePage;
import com.simform.pages.LoginPage;
import com.simform.pages.ZohoAppPage;
import com.simform.pages.crm.CRMHomePage;

public class LoginTestRough {

	public static void main(String[] args) throws InterruptedException {

		HomePage home = new HomePage();
		LoginPage lp = home.goToLogin();
		ZohoAppPage zp = lp.doLogin("chintansimform980@gmail.com", "Chatdone*1.");
		zp.gotoCRM();

		AccountsPage account = Page.menu.gotoAccounts();

		CreateAccounts cap = account.gotoCreateAccounts();
		cap.createAccount("Chintan");

	}

}
