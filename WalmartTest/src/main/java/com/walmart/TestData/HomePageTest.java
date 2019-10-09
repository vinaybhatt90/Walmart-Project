package com.walmart.TestData;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.qa.base.TestBase;
import com.walmart.qa.pages.CreditCardPage;
import com.walmart.qa.pages.HomePage;
import com.walmart.qa.pages.LoginPage;
import com.walmart.qa.pages.OrderHistoryPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	OrderHistoryPage orderHistoryPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		// login class object created
		orderHistoryPage = new OrderHistoryPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("EmailAddress"), prop.getProperty("Password"));
		homePage.SearchOption("vegetables");
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePaageTitle();
		Assert.assertEquals(homePageTitle, "Walmart Canada", "HomePage Title is not matched");
	}

	@Test(priority = 2)
	public void verifyOrderHistoryTest() {
		orderHistoryPage = homePage.clickOnOrderHistory();
	}

	@Test(priority = 3)
	public void verifyCreditCardTest() {
		homePage.clickOnCreditCardPage();
	}

	@Test(priority = 4)
	public void verifyAddressesTest() {
		homePage.clickOnAddresses();
	}

	@Test(priority = 5)
	public void verifyMyListPageTest() {
		homePage.clickonMyList();
	}

	@Test(priority = 6)
	public void verifyMyRecommendationPageTest() {
		homePage.clickOnMyReccomendation();
	}

	@Test(priority = 7)
	public void verifyMySubscriptionsTest() {
		homePage.clickOnMySubscriptions();
	}

	@Test(priority = 8)
	public void verifyPersonalSettingPageTest() {
		homePage.clickOnPersonalSetting();
	}

	@Test(priority = 9)
	public void verifyMyAccountPageTest() {
		homePage.clickOnMyAccount();
	}

	@Test(priority = 10)
	public void verifySignOutPageTest() {
		homePage.clickOnSignOut();
	}

	// @AfterMethod // public void teardown() { // driver.quit(); // }

	@Test
	public void verifysearchOption() {
		homePage.SearchOption("vegetables");

	}

	@Test
	public void verifysearchResult() {
		homePage.searchResult();
	}

	@Test
	public void verifysortByName() {
		homePage.sortByName();
	}

	@Test
	public void verifyTotalProduct() {
		System.out.println(homePage.listofTotalProduct());
	}

	@Test
	public void verifyPriceofProduct() {
		System.out.println(homePage.priceofProducts());
	}

	@Test
	public void verifysortbyPrice() {
		homePage.sortbyPrice();
	}

	@Test
	public void verifyFilterByBrand() {
		homePage.filterByBrand();
	}
}
