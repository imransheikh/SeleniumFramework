package com.app.scripts;

import static com.app.extent.report.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.app.utils.DriverTestCase;
import com.app.utils.ExtentReport;
import com.aventstack.extentreports.ExtentTest;

public class TC003_ForgotPasswordScript extends DriverTestCase {

	@Test
	public void ForgotPasswordTest(Method method) throws InterruptedException {

		startTest(method.getName(), "ForgotPasswordTest");
		// click on login button at home screen
		loginPage.clickOnLoginButtonAtHomeScreen();

		// click on need help button
		loginPage.clickOnNeedHelpLink();

		// enter email address
		String emailAddress = propertyReader.readApplicationFile("EmailAddress");
		loginPage.enterForgotEmailAddress(emailAddress);

		// click on send password reset button
		loginPage.clickOnSendPasswordResetButton();

		// click on send password reset button
		String resetPasswordMessage = loginPage.getForgotPasswordResetMessage();
		// verify that reset message after sending the forgot password email
		Assert.assertTrue(resetPasswordMessage.contains("Check Your Email"));
		

	}

}
