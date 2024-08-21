package com.inetBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLutility;

public class TC_login_BDD_pattern_002 extends BaseTest {
	
	
	
	@Test(dataProvider = "TestData")
	public void loginTest(String un , String pw) throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(un);
		lp.setPassword(pw);
		lp.loginAction();
		Thread.sleep(2000);
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		//	Assert.assertTrue(false);
	}
		else {
			//Assert.assertTrue(true);
			lp.logoutAction();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}}
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			captureScreenshot(driver,"loginTest");
			return true;
		} catch (Exception e) {
			
			return false;
		}}
	@DataProvider(name ="TestData")
	public Object[][] getData() throws Exception {
		//XLutility xl = new XLutility(); 
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/practiceCreds.xlsx";
		int rowSize = XLutility.getRowCount(path, "Sheet1");
		int ColSize = XLutility.getcolCount(path, "Sheet1", 1);
		Object[][] TestData = new Object[rowSize][ColSize];
		for (int i = 1; i < rowSize; i++) {
			for (int j = 0; j < ColSize; j++) {
				TestData[i][j] = XLutility.getCellData(path, "Sheet1", i, j);
				
			}
		}
		return TestData;
		
		
	}
	
}
