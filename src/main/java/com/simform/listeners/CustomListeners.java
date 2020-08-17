package com.simform.listeners;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.simform.base.Page;
import com.simform.utilities.Utilities;

public class CustomListeners extends Page implements ITestListener {

	public void onTestStart(ITestResult result) {
	
		
		test = reo.startTest(result.getName().toUpperCase());
		//runmodes - Y
		
	}

	public void onTestSuccess(ITestResult result) {
	
		test.log(LogStatus.PASS, result.getName().toUpperCase() + "PASS");
		reo.endTest(test);
		reo.flush();
		
	}

	public void onTestFailure(ITestResult result) {
		
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");		
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.FAIL, result.getName().toUpperCase() + "Failed with exception" + result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));

		
		//Reporter.log("Login successfully");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+">Screenshot</a>");
		reo.endTest(test);
		reo.flush();
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(LogStatus.SKIP,result.getName().toUpperCase() + "Skipped the test as the Tun mode is NO");
		reo.endTest(test);
		reo.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
