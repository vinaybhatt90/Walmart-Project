package com.walmart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmart.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory -ObjRep.

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "account-signin-btn")
	WebElement loginBtn;

	

	// initializing the page objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);//important stuff

	}

	// actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

//method for login
	public HomePage login(String EmailAddress, String Password) {
		email.sendKeys(EmailAddress);
		password.sendKeys(Password);
		loginBtn.submit();

		return new HomePage();

	}
}
