package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddnewCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_addNewCustomer_003 extends BaseTest{
@Test
public void addingcust() throws IOException, Exception {
	LoginPage lp = new LoginPage(driver);
	lp.setUserName(userName);
	lp.setPassword(passWord);
	lp.loginAction();
	Thread.sleep(2000);
	AddnewCustomerPage custPage = new AddnewCustomerPage(driver);
	custPage.addingNewCust();
	Thread.sleep(2000);
	custPage.custName("santhosh");
	custPage.Gender();
	custPage.dateofBirthInfo("12", "07", "1999");
	Thread.sleep(2000);
	custPage.address("kannur kamalapur");
	custPage.cityInfo("warangal");
	custPage.stateInfo("Telangana");
	custPage.PinCodeInfo(5051010);
	custPage.phNumInfo("6281467624"); 
	String randomAlphabetic = randomAlphabetic()+"@gmail.com";
	custPage.emailInfo(randomAlphabetic); 
	custPage.PasswordInfo("san@1245");
	custPage.submitAction();
	
	if (isPresent()==true) {
		captureScreenshot(driver,"addingcust");
		
		Assert.assertTrue(true);
	}
	else
	{
		
		Assert.assertTrue(false);
		
	}
	
	
}
public boolean isPresent() {
	boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
	return result;
}
//public boolean isPresent() {
//	try {
//		driver.switchTo().alert();
//		return true;
//	} catch (Exception e) {
//		return false;
//	}
//}

}