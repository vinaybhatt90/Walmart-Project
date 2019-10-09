package com.walmart.TestData;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.qa.base.TestBase;
import com.walmart.qa.pages.HomePage;
import com.walmart.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	// create a constructor

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		// login class object created
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Walmart Canada");
	}

	@Test(priority = 2)
	public void loginTest() {
		homepage = loginPage.login(prop.getProperty("EmailAddress"),prop.getProperty("Password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
