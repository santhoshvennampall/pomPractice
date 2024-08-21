package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
      public LoginPage(WebDriver driver) {
    	  	this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "uid") WebElement username; 
	@FindBy(name="password") WebElement password; 
	@FindBy(name = "btnLogin") WebElement loginbtn;
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a") WebElement logout;


public void setUserName(String uname) {
	username.sendKeys(uname);
}
public void setPassword(String pw) {
	password.sendKeys(pw);
}
public void loginAction() {
	loginbtn.click();
}
public void logoutAction() {
	logout.click();
}
}