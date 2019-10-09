package com.walmart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmart.qa.base.TestBase;

public class PersonalSettingPage extends TestBase {

	@FindBy(id = "set-edit-info")
	WebElement PersonalInfoEdit;

	@FindBy(xpath = "//*[@id=\"phone\"]")
	WebElement PhoneNumber;

	@FindBy(xpath = "//*[@id=\"personal-info\"]/fieldset/label[3]/input")
	WebElement FirstName;

	@FindBy(xpath = "//*[@id=\"personal-info\"]/fieldset/label[4]/input")
	WebElement LastName;

	@FindBy(xpath = "//*[@id=\"personal-info\"]/fieldset/label[5]/input")
	WebElement PostalCode;

	public PersonalSettingPage() {

		PageFactory.initElements(driver, this);
	}

	public String verifyHomePaageTitle() {
		return driver.getTitle();
	}

	public PersonalSettingPage clickonPersonalEdit() {
		PersonalInfoEdit.click();
		return new PersonalSettingPage();

	}

	public PersonalSettingPage insertPhoneNumber() {
		PhoneNumber.clear();
		PhoneNumber.sendKeys("289-339-2439");
		return new PersonalSettingPage();
	}

	public void insertFirstName() {
		FirstName.sendKeys("Vinu");
	}

	public void inserLastName() {
		LastName.sendKeys("Binu");
	}

	public void insertPostalcode() {
		PostalCode.sendKeys("L9C2B8");
	}

}
