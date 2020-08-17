package com.simform.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import com.simform.pages.HomePage;
import com.simform.pages.LoginPage;
import com.simform.pages.ZohoAppPage;
import com.simform.utilities.Utilities;

public class LoginTest extends BaseTest {
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void loginTest(Hashtable<String,String> data) throws InterruptedException {
		
		HomePage home = new HomePage();
		LoginPage lp = home.goToLogin();
		lp.doLogin(data.get("username"), data.get("password"));
		
		
	}
	


}
