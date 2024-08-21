package com.inetBanking.testCases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetBanking.utilities.readConfig;

import net.bytebuddy.utility.RandomString;

public class BaseTest {
	readConfig readconfig = new readConfig();
	
	WebDriver driver;
	public String userName =readconfig.getuserName();
	public String passWord = readconfig.getPassword();
	public String url = readconfig.getAppurl();
	
//	public Logger  logger;
	
@BeforeClass
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);  
	
//	logger = Logger.getLogger("POMframeWorkDemo");
//	PropertyConfigurator.configure("log4j.properties");
//	DOMConfigurator.configure("log4j.xml");
	
}
@AfterClass
public void TearDown() {
	driver.quit();
}
public void captureScreenshot(WebDriver driver, String tcname) throws IOException {
	TakesScreenshot tc = (TakesScreenshot) driver;
	File file = tc.getScreenshotAs(OutputType.FILE);
	File path = new File(System.getProperty("user.dir")+"/Screenshots/" + tcname+".png");
	FileUtils.copyFile(file, path);
	System.out.println("Screenshot taken succesfully");
}
public String randomAlphabetic() {
	String randomalpha = RandomString.make(8);
	
	return randomalpha;
}
//public String randomNumeric() {
//	String randomalpha = RandomString.make(4);
//	return randomalpha;
//}
}
