package com.app.extent.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
    	String extentReportPath = System.getProperty("user.dir") + "/ExtentReport/ExtentReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
        reporter.config().setDocumentTitle("AUTOMATION REPORT");
        reporter.config().setReportName("IMRAN SHEIKH");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Company Name", "HUDL");
        //extentReports.setSystemInfo("Tester Name", "Imran");
        return extentReports;
        
     
       
    }
}

