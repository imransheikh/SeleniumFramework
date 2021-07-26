package com.app.utils;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {


	public  void configureExtentReport() {
		String extentReportPath = System.getProperty("user.dir") + "/ExtentReport/ExtentReport.html";
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(extentReportPath);
		sparkReport.config().setTheme(Theme.STANDARD);
		sparkReport.config().setDocumentTitle("AUTOMATION REPORT");
		sparkReport.config().setReportName("IMRAN SHEIKH");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		extent.setSystemInfo("Company Name", "HUDL");
		extent.setSystemInfo("Tester Name", "Imran");
	}
	
	
	/*
	 * public void flushExtentReport() { //extent.flush(); }
	 * 
	 * 
	 * public ExtentReports getExtent() { // return extent; }
	 */
}
