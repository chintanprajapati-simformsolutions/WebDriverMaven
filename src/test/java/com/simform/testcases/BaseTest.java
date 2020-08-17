package com.simform.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import com.simform.base.Page;

public class BaseTest {
	
	
	@AfterMethod
	@AfterSuite
	public void tearDown(){
		
		//Page.quit();
		
	}

}
