package com.inetBanking.utilities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class reports extends TestListenerAdapter{

	

	ExtentReports extent;
	ExtentSparkReporter reporter;
	ExtentTest etest;
	
	@Override
	public void onStart(ITestContext testContext) {

		LocalDateTime DateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.mm.dd.hh.mm.ss");
		String subFolder = "Test-Report-"+DateTime.format(formatter)+ ".html";  // report name in the project folder
		
		extent= new ExtentReports();
		reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+subFolder); // path of the report
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host name", "Localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "santhosh.v22");
		
		reporter.config().setDocumentTitle("InetBanking Test Project");   			// Title of Report (on top we get as driver.getTitle)
		reporter.config().setReportName("Functional Test Automation report");		// name of the Report on right top corner
		reporter.config().setTheme(Theme.STANDARD);									//dark color background
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		etest= extent.createTest(result.getName());
		etest.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		etest = extent.createTest(result.getName());
		etest.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		String path = System.getProperty("user.dir")+"\\Screenshots\\"+ result.getName()+".png";   //it will take ss from this path 
		
		
		File f = new File(path);
		
		if (f.exists()) {
			try {
				  etest.fail("Screenshot is below");
				  etest.addScreenCaptureFromPath(path) ; 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		etest = extent.createTest(result.getName());
		etest.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}
	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}
