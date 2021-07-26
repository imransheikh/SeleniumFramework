package com.app.scripts;

import static com.app.extent.report.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.app.utils.DriverTestCase;
import com.app.utils.ExtentReport;
import com.app.utils.Log;
import com.aventstack.extentreports.ExtentTest;

public class TC002_Negative_LoginScript extends DriverTestCase {

	//static 	Logger log= LogManager.getLogger(TC002_Negative_LoginScript.class);

	
	@Test
	public void LoginNegativeTest(Method method ) throws InterruptedException {

		
		startTest(method.getName(), "LoginNegativeTest");
		Log.info("================Start==================");
		Log.info("click on login button at home screen");
		loginPage.clickOnLoginButtonAtHomeScreen();

		Log.info("enter email address");
		String emailAddress = propertyReader.readApplicationFile("EmailAddress");
		loginPage.enterEmailAddress(emailAddress);

		Log.info("enter password address");
		String password = propertyReader.readApplicationFile("WrongPassword");
		loginPage.enterPassword(password);

		Log.info("click on login button");
		loginPage.clickOnLoginButton();

		String loginErrorMessage = loginPage.getLoginErrorMessage();
		Log.info("Verify that error message should be displayed after providing incorrect credential");
		Assert.assertTrue(loginErrorMessage.contains("We didn't recognize that email and/or password"));
		Assert.assertTrue(false);
		Log.info("================End==================");
		
		
	}

}
