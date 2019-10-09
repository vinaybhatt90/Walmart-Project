package com.walmart.TestData;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.qa.base.TestBase;
import com.walmart.qa.pages.HomePage;
import com.walmart.qa.pages.LoginPage;
import com.walmart.qa.pages.PersonalSettingPage;

public class PersonalSettingPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	PersonalSettingPage PersonalSetting;

	public PersonalSettingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		// login class object created
		loginPage = new LoginPage();
		PersonalSetting = new PersonalSettingPage();
		homePage = loginPage.login(prop.getProperty("EmailAddress"), prop.getProperty("Password"));
		homePage.clickOnPersonalSetting();
		PersonalSetting.clickonPersonalEdit();
		
	}

	@Test
	public void clickonPersonalEditPageTest() {
		PersonalSetting =PersonalSetting.clickonPersonalEdit();
	}

	@Test
	public void insertPhoneNumber() {
		PersonalSetting.insertPhoneNumber();
	}

	@Test
	public void insertFisrtName() {
		PersonalSetting.insertFirstName();
	}

	// @AfterMethod
	// public void teardown() {
	// driver.quit();
	// }

		
		
	}

