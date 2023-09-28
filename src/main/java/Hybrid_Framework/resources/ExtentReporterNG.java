package Hybrid_Framework.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter  = new ExtentSparkReporter(path);
		reporter.config().setReportName("Mahesh");
		reporter.config().setDocumentTitle("My Automation Results");
		
		ExtentReports extent  = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Mahesh Automation Engineer");
		return extent;
	}

}
