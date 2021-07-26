package com.app.utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.app.pages.LoginPage;
import com.app.resources.LogTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class DriverTestCase {

	public PropertyReader propertyReader;
	public LoginPage loginPage;

	protected WebDriver driver;
	String driverType;
	public static ExtentReports extent;
	public static ExtentSparkReporter sparkReport;

	enum DriverType {
		Firefox, IE, Chrome
	}

	@BeforeClass
	public void setUp() {

		propertyReader = new PropertyReader();
		driverType = propertyReader.readApplicationFile("BROWSER");

		if (DriverType.Firefox.toString().equals(driverType)) {
			String geckoDriverPath = System.getProperty("user.dir") + "/drivers/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
			driver = new FirefoxDriver();

		} else if (DriverType.IE.toString().equals(driverType)) {
			driver = new InternetExplorerDriver();

		} else if (DriverType.Chrome.toString().equals(driverType)) {
			ChromeOptions chromeOptions = new ChromeOptions();
			String chromeDriverPath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
			System.out.println("Chrome path: " + chromeDriverPath);
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver(chromeOptions);
		} else {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		// JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.readyState").toString().equals("complete");

		String applicationUrl = propertyReader.readApplicationFile("ApplicationURL");
		getWebDriver().get(applicationUrl);

		loginPage = PageFactory.initElements(driver, LoginPage.class);
		System.out.println("I am before class");

	}

	@AfterClass
	public void tearDowm() {
		System.out.println("I am after class");
		driver.quit();

	}

	public void redirectToHomePage() {

		String applicationUrl = propertyReader.readApplicationFile("ApplicationURL");
		// getWebDriver().get(applicationUrl);
		getWebDriver().navigate().to(applicationUrl);

		// JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.readyState").toString().equals("complete");

	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public PropertyReader getProperty() {
		return propertyReader;
	}

	public int getRandomInteger(int aStart, int aEnd, Random aRandom) {
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) aEnd - (long) aStart + 1;

		long fraction = (long) (range * aRandom.nextDouble());
		int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}

	public String randomString(int len) {

		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

}
