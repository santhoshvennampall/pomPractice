package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddnewCustomerPage {
	WebDriver driver;
	public AddnewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH , using = "/html/body/div[3]/div/ul/li[2]/a") WebElement newCustomerlink;
	@FindBy(name = "name") WebElement custName;
	@FindBy(xpath ="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]") WebElement Gender;
	@FindBy(id = "dob") WebElement dateofBirthInfo;
	@FindBy(name ="addr") WebElement address;
	@FindBy(name ="city") WebElement cityInfo;
	@FindBy(name ="state") WebElement stateInfo;
	@FindBy(name ="pinno") WebElement PinCodeInfo;
	@FindBy(name ="telephoneno") WebElement phNumInfo;
	@FindBy(name ="emailid") WebElement emailInfo;
	@FindBy(name ="password") WebElement PasswordInfo;
	@FindBy(name ="sub") WebElement submitBtn;
	
	public void addingNewCust() {
		newCustomerlink.click();
	}
	public void custName(String name) {
		custName.sendKeys(name);
	}
	public void Gender() {
		Gender.click();
	}
	public void dateofBirthInfo(String mm,String dd , String yyyy) {
		dateofBirthInfo.sendKeys(mm);
		dateofBirthInfo.sendKeys(dd);
		dateofBirthInfo.sendKeys(yyyy);
	}
	public void address(String adds) {
		address.sendKeys(adds);
	}
	public void cityInfo(String city) {
		cityInfo.sendKeys(city);
	}
	public void stateInfo(String state) {
		stateInfo.sendKeys(state);
	}
	public void PinCodeInfo(double pin ) {
		PinCodeInfo.sendKeys(String.valueOf(pin) );
	}
	public void phNumInfo(String phnum) {
		phNumInfo.sendKeys(String.valueOf(phnum));
	}
	public void emailInfo(String email) {
		emailInfo.sendKeys(email);
	}
	public void PasswordInfo(String pw) {
		PasswordInfo.sendKeys(pw);
	}
	public void submitAction() {
		submitBtn.click();
	}
	
}
