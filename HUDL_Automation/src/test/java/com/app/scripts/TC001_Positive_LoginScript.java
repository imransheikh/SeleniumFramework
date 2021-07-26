package com.app.scripts;


import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.app.utils.DriverTestCase;
import com.app.utils.ExtentReport;
import com.app.utils.Log;
import com.aventstack.extentreports.ExtentTest;
import static com.app.extent.report.ExtentTestManager.startTest;
public class TC001_Positive_LoginScript extends DriverTestCase {

	//static 	Logger log= LogManager.getLogger(TC001_Positive_LoginScript.class);
	
	
	@Test
	public void LoginPositiveTest(Method method) throws InterruptedException {

		startTest(method.getName(), "LoginPositiveTest");
		Log.info("============END======================");
		Log.info("click on login button at home screen");
		loginPage.clickOnLoginButtonAtHomeScreen();
		
		Log.info("enter email address");
		String emailAddress = propertyReader.readApplicationFile("EmailAddress");
		loginPage.enterEmailAddress(emailAddress);

		Log.info("enter password address");
		String password = propertyReader.readApplicationFile("Password");
		loginPage.enterPassword(password);

		Log.info(" click on login button");
		loginPage.clickOnLoginButton();

		Log.info("verify after login home menu should be displayed");
		boolean result = loginPage.isHomeMenuDisplayed();
		Assert.assertTrue(result, "Home button should be displayed after successfully login");

		Log.info("click on profile display name");
		loginPage.clickOnProfileDisplayName();

		Log.info("click on logout link");
		loginPage.clickOnlogoutLink();
		Log.info("============END======================");
		
		

	}

}
