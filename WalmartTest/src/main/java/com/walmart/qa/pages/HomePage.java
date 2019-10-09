package com.walmart.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.walmart.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@id=\"account-menu-btn\"]/p/span[2]")
	WebElement myaccount;

	@FindBy(xpath = "//*[@id=\"my-account-nav\"]/section[1]/ul/li[1]/a")
	WebElement myReccomendation;

	@FindBy(xpath = "//*[@id=\"my-account-nav\"]/section[1]/ul/li[3]/a")
	WebElement orderHistory;

	@FindBy(xpath = "//*[@id=\"my-account-nav\"]/section[1]/ul/li[4]/a")
	WebElement mySubscriptions;

	@FindBy(xpath = "//*[@id=\"my-account-nav\"]/section[1]/ul/li[6]/a")
	WebElement myRegistries;

	@FindBy(xpath = "//*[@id=\"my-account-nav\"]/section[1]/ul/li[7]/a")
	WebElement personalSetting;

	@FindBy(xpath = "//*[@id=\"my-account-nav\"]/section[1]/ul/li[10]/a")
	WebElement creditCard;

	@FindBy(xpath = "//*[@id=\"my-account-nav\"]/section[1]/ul/li[5]/a")
	WebElement myList;

	@FindBy(xpath = "//*[@id=\"my-account-nav\"]/section[1]/ul/li[9]/a")
	WebElement addresses;

	@FindBy(xpath = "//*[@id=\"my-account-nav\"]/section[1]/ul/li[11]/a")
	WebElement signOut;

	@FindBy(id = "global-search")
	WebElement search;

	@FindBy(id = "shelf-sort-count")
	WebElement searchresult;

	@FindBy(xpath = "//*[@id=\"shelf-sort\"]/ul/li[2]")
	WebElement sortbyname;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[4]/section[3]/div[3]/div/article")
	List<WebElement> totalproducts;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[4]/section[3]/div[3]/div/article")
	List<WebElement> priceofProducts;

	@FindBy(xpath = "//*[@id=\"shelf-sort\"]/ul/li[4]/a")
	WebElement SortbyPrice;

	@FindBy(xpath = "//*[@id=\"rmi-brand-id-0\"]/a/label")
	WebElement FilterbyBrand;

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public String verifyHomePaageTitle() {
		return driver.getTitle();
	}

	public MyAccountPage clickOnMyAccount() {
		myaccount.click();
		return new MyAccountPage();
	}

	public MyRecommendationsPage clickOnMyReccomendation() {
		myReccomendation.click();
		return new MyRecommendationsPage();
	}

	public OrderHistoryPage clickOnOrderHistory() {
		orderHistory.click();
		return new OrderHistoryPage();
	}

	public MySubscriptionsPage clickOnMySubscriptions() {
		mySubscriptions.click();
		return new MySubscriptionsPage();
	}

	public MyRegistriesPage clickOnMyRegistries() {
		myRegistries.click();
		return new MyRegistriesPage();
	}

	public PersonalSettingPage clickOnPersonalSetting() {
		personalSetting.click();
		return new PersonalSettingPage();
	}

	public CreditCardPage clickOnCreditCardPage() {
		creditCard.click();
		return new CreditCardPage();
	}

	public MyListsPage clickonMyList() {
		myList.click();
		return new MyListsPage();
	}

	public AddressesPage clickOnAddresses() {
		addresses.click();
		return new AddressesPage();
	}

	public SignOutPage clickOnSignOut() {
		signOut.click();
		return new SignOutPage();
	}

	public HomePage SearchOption(String itemname) {
		search.sendKeys(itemname);
		driver.findElement(By.xpath("//*[@id=\"simplified-header\"]/div[2]/div/div[4]/form/button/span")).click();
		// driver.findElement(By.xpath("//*[@id=\"thumb-10275053\"]/a/div[2]/div[2]/img")).click();
		// driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[8]/div[2]/button")).submit();

		List pagination = driver.findElements(By.xpath("//a[@id='loadmore' and @class='page-select-list-btn']"));

		if (pagination.size() > 0) {
			System.out.println("pagination exists" + pagination.size());

			for (int i = 0; i < pagination.size(); i++) {
				((WebElement) pagination.get(i)).click();
			}
		} else {
			System.out.println("pagination not exists");
		}

		Select rangerSelector = new Select(driver.findElement(By.xpath("//select[@class='page-select']")));
		rangerSelector.deselectByIndex(1);

		return new HomePage();

	}

	public HomePage searchResult() {
		// System.out.println(searchresult.getText());
		Assert.assertEquals(searchresult.getText(), "1 - 60 of 4074 items");
		return new HomePage();

	}

	public HomePage sortByName() {
		sortbyname.click();
		return new HomePage();
	}

	public int listofTotalProduct() {
		return totalproducts.size();

	}

	public List<WebElement> priceofProducts() {
		return priceofProducts;
	}

	public HomePage sortbyPrice() {
		SortbyPrice.click();
		return new HomePage();
	}

	public HomePage filterByBrand() {
		FilterbyBrand.click();
		return new HomePage();
	}

}
