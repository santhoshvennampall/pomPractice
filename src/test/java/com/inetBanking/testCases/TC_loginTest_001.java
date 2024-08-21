package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_loginTest_001 extends BaseTest{


	@Test
	public void loginTest() throws IOException {
		// from Base class 
	//	logger.info("url entered");
		LoginPage lp = new LoginPage(driver) ; // creating  LoginPage object
		lp.setUserName(userName); // from loginPage(method) & userName from readConfig class
	//	logger.info("userName entered");
		lp.setPassword(passWord);
	//	logger.info("passWord entered");
		lp.loginAction();
	//	logger.info("login successfully");
		
		String exp = "Guru99 Bank Manager HomePage";
		String act = driver.getTitle();
		if (exp.equals(act)) {
			Assert.assertTrue(true);
	//		logger.info("entered into HomePage");
		}else
		{
			captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
		}
}
}
